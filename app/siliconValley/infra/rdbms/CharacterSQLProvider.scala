package siliconValley.infra.rdbms

import scalikejdbc.{NoExtractor, SQL}

class CharacterSQLProvider {

  def selectAll: SQL[Nothing, NoExtractor] =
    SQL( """SELECT * FROM `characters`""")

  def selectByName(name:String):SQL[Nothing,NoExtractor] =
  SQL(
  """
    |SELECT *
    |FROM
    | `characters`
    | WHERE
    | `name` = /*'name*/'name'
  """.stripMargin
  ).bindByName('name -> name)


}