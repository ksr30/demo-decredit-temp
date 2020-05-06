package com.knoldus.daml.populatetables

import com.knoldus.daml.dao.PartyDao
import com.knoldus.daml.domain.Party

import scala.concurrent.ExecutionContext.global
import scala.concurrent.ExecutionContextExecutor

class PopulatePartyTable(partyDao: PartyDao) {

  implicit val executionContext: ExecutionContextExecutor = global

  partyDao.insert(Party("ledger-party-0d75dc9d-5924-4769-b214-4de882074c3f", "Borrower")).map{
    result=>println(result)
    }

  partyDao.insert(Party("ledger-party-704ad1bf-88c5-414b-b8bf-2aa8feebd1a3", "Axis")).map{
    result=>println(result)
  }
  partyDao.insert(Party("ledger-party-5c7c1db4-1020-4b2d-8b35-b800dec32581", "HDFC")).map{
    result=>println(result)
  }
  partyDao.insert(Party("1111","SBI")).map{
    result=>println(result)
  }

  //partyDao.insert(Party("1","ggg")).map{
    //result=>println(result)
  //}

}
