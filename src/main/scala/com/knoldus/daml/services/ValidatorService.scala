package com.knoldus.daml.services

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.headers.{Authorization, OAuth2BearerToken}
import akka.http.scaladsl.model.{HttpEntity, HttpMethods, HttpRequest, HttpResponse}
import akka.util.ByteString
import com.knoldus.daml.routes.contract.validaton.AcceptInitialRequest
import com.typesafe.config.Config

import scala.concurrent.ExecutionContext.global
import scala.concurrent.{ExecutionContextExecutor, Future}

class ValidatorService(conf: Config, validationService: ValidationService)(implicit val system: ActorSystem) {
  implicit val executionContext: ExecutionContextExecutor = global

  def acceptRequest(borrowerRequest: AcceptInitialRequest, ledgerId: String): Future[HttpResponse] = {


    val body =
      s"""{
    "templateId": "${borrowerRequest.templateId}",
    "contractId": "${borrowerRequest.contractId}",
    "choice":"${borrowerRequest.choice}",
    "argument": {
    "validation_id":"${borrowerRequest.argument.validation_id}",


       }
    }"""


    val data = ByteString(body)
    Http().singleRequest(HttpRequest(
      method = HttpMethods.POST,
      uri = s"${conf.getConfig("dabl").getString("url")}/$ledgerId/v1/exercise",
      headers = List(Authorization(OAuth2BearerToken(conf.getConfig("jwt").getString("tokenLender")))),
      entity = HttpEntity(data)
    )
    )


  }

  def fetchContractOfParty(ledgerId: String): Future[HttpResponse] = {

    val httpResponse = Http().singleRequest(HttpRequest(
      method = HttpMethods.GET,
      uri = s"${conf.getConfig("dabl").getString("url")}/$ledgerId/v1/query",
      headers = List(Authorization(OAuth2BearerToken(conf.getConfig("jwt").getString("tokenLender"))))
    ))
    httpResponse
  }


}
