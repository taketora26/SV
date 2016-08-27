package siliconValley.infra.rdbms

import scalikejdbc.{NoExtractor, SQL}

class CharacterSQLProvider {

  def selectAll: SQL[Nothing, NoExtractor] =
    SQL( """SELECT * FROM `characters`""")

}