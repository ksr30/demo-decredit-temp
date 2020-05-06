package com.knoldus.daml.routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.knoldus.daml.routes.contract.validaton.AcceptInitialRequest
import com.knoldus.daml.services.ValidatorService

class ValidatorRoutes(validatorService: ValidatorService) extends BaseRoutes {
  val routes: Route =
    path(Segment / "v1" / "exercise") {
      ledgerId =>
        (post & entity(as[AcceptInitialRequest])) { initialRequest =>
          onSuccess(validatorService.acceptRequest(initialRequest, ledgerId)) {
            result =>
              complete(result)
          }
        }
    } ~
      path(Segment / "v1" / "query") {
        ledgerId =>
          get {
            complete(validatorService.fetchContractOfParty(ledgerId))
          }
      }
}





