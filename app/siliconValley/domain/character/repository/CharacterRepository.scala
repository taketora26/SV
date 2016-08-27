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
        fullName = rs.string("full_name"),
        realName = rs.string("real_name"),
        roleId = rs.int("role_id"),
        skill = rs.string("skill"),
        imageUrl = rs.string("image_url")
    )
  }


}