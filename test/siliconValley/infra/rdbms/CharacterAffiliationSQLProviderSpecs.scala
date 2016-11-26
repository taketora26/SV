package siliconValley.infra.rdbms

import org.specs2.mutable.Specification

class CharacterAffiliationSQLProviderSpecs extends Specification
with WithTestTable {

  override protected val testTableName: String = "character_affiliation"

  sequential

  val characterAffiliationSQLProvider = new CharacterAffiliationSQLProvider

  "CharacterAffiliationSQLProvider" >> {

    "characterIdからcompanyIdを返すことができる" >> {
      withSession {

        //selectする
        val actual = characterAffiliationSQLProvider.selectByCharacterId(2)
          .map(rs =>
            rs.int("company_id")
            ).single().apply()


        println(actual)
        val expectCompanyId = Some(1)

        actual must beEqualTo(expectCompanyId)

      }
    }
  }

}
