package com.knoldus.daml.bootstrap

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.knoldus.daml.services.{LenderServices, LoanRequestService, ValidationService}
import com.typesafe.config.Config

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

class ServiceInstantiator(conf: Config, daoInstantiator: DaoInstantiator)(implicit system: ActorSystem) {
  implicit val ec: ExecutionContext = system.dispatcher


  val validationService = new ValidationService(daoInstantiator.partyDao)
  val loanRequestService = new LoanRequestService(conf,validationService)
  val lenderService = new LenderServices(conf,validationService)
}
