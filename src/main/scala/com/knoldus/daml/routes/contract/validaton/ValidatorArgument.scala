package com.knoldus.daml.routes.contract.validaton

import play.api.libs.json.{Json, OFormat}

case class ValidatorArgument(validation_id:Int)


object ValidatorArgument {

  implicit val Argument: OFormat[ValidatorArgument] = Json.format[ValidatorArgument]

}
