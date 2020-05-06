package com.knoldus.daml.routes.contract.loanrequest

import play.api.libs.json.{Json, OFormat}

case class InitialLoanRequest(
    personalDetails : PersonalDetails ,
    loanRequirementDetails : LoanRequirementDetails,
    professionalDetails : ProfessionalDetails,
    validationAuthority : String,
    borrower : String,
    listOfLenders :List[String]
                               )

object InitialLoanRequest {

  implicit val InitialLoanRequestFormats: OFormat[InitialLoanRequest] = Json.format[InitialLoanRequest]

}