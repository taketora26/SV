package siliconValley.domain.character.repository

import siliconValley.infra.rdbms.CharacterSQLProvider
import scalikejdbc.{WrappedResultSet, AutoSession, DBSession}
import siliconValley.domain.character.model.Character
import scala.util.Try

class CharacterRepository(
                           val characterSQLProvider: CharacterSQLProvider = new CharacterSQLProvider
                         )(
                           implicit val session: DBSession = AutoSession
                         ){

 def resolveAll:Try[List[Character]] = Try {
   characterSQLProvider.selectAll.map(wrappedResultSet).list().apply()
 }

  private def wrappedResultSet(rs: WrappedResultSet): Character = {
    Character(
      id = rs.int("id"),
        name = rs.string("name"),
        fullName = rs.string("fullName"),
        realName = rs.string("realName"),
        roleId = rs.int("role_id"),
        skill = rs.string("skill"),
        imageUrl = rs.string("imageUrl")
    )
  }


}