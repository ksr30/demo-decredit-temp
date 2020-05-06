package com.knoldus.daml.bootstrap

import com.knoldus.daml.populatetables.PopulatePartyTable

class PopulateTableInstantiator(daoInstantiator: DaoInstantiator) {
  new PopulatePartyTable(daoInstantiator.partyDao)
}
