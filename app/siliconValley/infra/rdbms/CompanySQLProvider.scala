package siliconValley.infra.rdbms

import scalikejdbc.{NoExtractor, SQL}

class CompanySQLProvider {

  def selectById(id:Long):SQL[Nothing,NoExtractor] =
  SQL(
  """
    |SELECT *
    |FROM
    | `company`
    | WHERE
    | `id` = /*'id*/1
  """.stripMargin
  ).bindByName('id -> id)

}