package com.knoldus.daml.routes.contract.loanrequest

import play.api.libs.json.{Json, OFormat}

case class VerifiedRequest(
                            validation_id : Int,
                            personalDetails: PersonalDetails,
                            loanRequirementDetails: LoanRequirementDetails,
                            professionalDetails : ProfessionalDetails,
                            borrower: String,
                            listOfLenders: List[String],
                            validationAuthority: String
                          )

object VerifiedRequest {

  implicit val VerifiedRequestFormat : OFormat[VerifiedRequest] = Json.format[VerifiedRequest]

}
