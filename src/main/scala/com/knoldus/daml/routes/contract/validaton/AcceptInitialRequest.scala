package com.knoldus.daml.routes.contract.validaton

import play.api.libs.json.{Json, OFormat}

case class AcceptInitialRequest(templateId: String,contractId:String,choice:String,argument: ValidatorArgument)


object AcceptInitialRequest {

  implicit val CreateLenderProposalReads: OFormat[AcceptInitialRequest] = Json.format[AcceptInitialRequest]

}
