package com.knoldus.daml.bootstrap

import com.knoldus.daml.routes.{LenderRoutes, LoanRequestRoutes, ValidationRoutes}
import com.typesafe.config.Config
import akka.http.scaladsl.server.Directives.{concat, ignoreTrailingSlash}
import akka.http.scaladsl.server.Route

class RouteInstantiator(conf:Config,services:ServiceInstantiator) {

  private val loanRequestRoutes = new LoanRequestRoutes(services.loanRequestService).routes
  private val validationRoutes = new ValidationRoutes(services.validationService).routes
  private val lenderRoutes = new LenderRoutes(services.lenderService).routes
  val routes: Route =
    ignoreTrailingSlash {
      concat(
        loanRequestRoutes,
        validationRoutes,
        lenderRoutes
      )
  }
}
