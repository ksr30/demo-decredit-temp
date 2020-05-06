package com.knoldus.daml.services

import com.knoldus.daml.dao.PartyDao
import com.knoldus.daml.domain.Party
import slick.jdbc.H2Profile.api._
import scala.concurrent.duration._

import scala.concurrent.{Await, ExecutionContext, Future}

class ValidationService(partyDao: PartyDao)(implicit val ec: ExecutionContext) {

  //
  def insertPartyName: Future[Int] = {
    println("insidePartyName")
    partyDao.insert(Party("ledger-party-0d75dc9d-5924-4769-b214-4de882074c3f", "Borrower")).map{
      result=>println(result);result
    }
    partyDao.insert(Party("ledger-party-4d573ad8-60a1-4f30-bad0-aa99993631df", "Axis"))
    partyDao.insert(Party("", "HDFC"))
    partyDao.insert(Party("1111","SBI"))
  }

  def getPartyId(borrowerId: String): Future[String] = {
    partyDao.findById(borrowerId).map {
      case None => "No record Found"
      case Some(party) => party.party
    }
  }

  /**
   * This function takes party name as parameter and returns the id
   * @param party is the name of the stakeholder
   * @return borrowerId of the party
   */
  def getPartyIdByName(party: String) = {
    val partyId = partyDao.findByName(party).map {
      case None => "No record Found"
      case Some(borrowerId) => borrowerId.borrowerId
    }
   // Await.result(partyId, 5.seconds)

    partyId
  }

}



