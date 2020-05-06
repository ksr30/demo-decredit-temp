package com.knoldus.daml.routes.contract.loanrequest

import play.api.libs.json.{Json, OFormat}

case class LoanRequirementDetails(loan_purpose : String, amount_requirement : Int, cibil_score : Int)

object LoanRequirementDetails {

  implicit val LoanRequirementDetailsFormats: OFormat[LoanRequirementDetails] = Json.format[LoanRequirementDetails]

}
