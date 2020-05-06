package com.knoldus.daml.routes.contract.loanrequest

import play.api.libs.json.{Json, OFormat}

case class CreateLoanRequest(templateId: String,payload: InitialLoanRequest)

object CreateLoanRequest {

  implicit val CreateLoanRequestReads: OFormat[CreateLoanRequest] = Json.format[CreateLoanRequest]

}