package com.knoldus.daml.routes.contract.loanrequest

import play.api.libs.json.{Json, OFormat}

case class PersonalDetails(name : String, age : Int, phone_no : Int, address : String, e_mail : String, pan_card_no : Int)

object PersonalDetails {

  implicit val PersonalDetailsFormat: OFormat[PersonalDetails] = Json.format[PersonalDetails]

}
