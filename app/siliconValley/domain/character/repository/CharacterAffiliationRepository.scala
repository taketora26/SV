package siliconValley.domain.character.repository

import scalikejdbc.{AutoSession, DBSession, WrappedResultSet}
import siliconValley.infra.rdbms.CharacterAffiliationSQLProvider

import scala.util.Try

class CharacterAffiliationRepository(
                                      val characterAffiliationSQLProvider: CharacterAffiliationSQLProvider = new CharacterAffiliationSQLProvider
                                    )(
                                      implicit val session: DBSession = AutoSession
                                    ) {

  def resolveCompanyIdByCharacterId(characterId:Long): Try[Option[Long]] = Try {
    characterAffiliationSQLProvider.selectByCharacterId(characterId)
      .map(wrappedResultSet).single().apply()
  }

  def store(companyId: Long, characterId: Long):Try[Long] = Try {
    characterAffiliationSQLProvider.insert(companyId,characterId).updateAndReturnGeneratedKey().apply()
  }

  private def wrappedResultSet(rs: WrappedResultSet):Long = {
    rs.long("company_id")
  }

}