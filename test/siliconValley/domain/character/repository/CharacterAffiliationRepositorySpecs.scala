package siliconValley.domain.character.repository

import org.specs2.mutable.Specification
import siliconValley.infra.rdbms.WithTestTable

class CharacterAffiliationRepositorySpecs extends Specification
with WithTestTable {

  override protected val testTableName: String = "character_affiliation"

  sequential

  val characterAffiliationRepository = new CharacterAffiliationRepository

  "CharacterAffiliationRepository" >> {

    "characterIdからcompanyIdを返すことができる" >> {
      withSession {
        val CharacterId: Long = 2
        val resolveCompanyIdByCharacterId = characterAffiliationRepository.resolveCompanyIdByCharacterId(CharacterId)

        val expectCompanyId = Some(1)

        resolveCompanyIdByCharacterId must beSuccessfulTry

        resolveCompanyIdByCharacterId.get must beEqualTo(expectCompanyId)
      }
    }
  }
}
