package siliconValley.domain.character.repository

import akka.stream.impl.fusing.Log
import scalikejdbc.{WrappedResultSet, AutoSession, DBSession}
import siliconValley.infra.rdbms.{CharacterAffiliationSQLProvider, CharacterSQLProvider}

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

  private def wrappedResultSet(rs: WrappedResultSet):Long = {
    rs.long("company_id")
  }

}