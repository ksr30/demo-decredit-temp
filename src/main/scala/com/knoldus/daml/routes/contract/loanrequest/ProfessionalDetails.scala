package com.knoldus.daml.routes.contract.loanrequest

import play.api.libs.json.{Json, OFormat}

case class ProfessionalDetails(current_company_name : String, monthly_in_hand_salary : Int, job_designation : String, work_experience_in_years : Int)

object ProfessionalDetails {

  implicit val CollateralDetailsFormats: OFormat[ProfessionalDetails] = Json.format[ProfessionalDetails]

}
