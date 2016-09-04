package siliconValley.infra.rdbms

import scalikejdbc.{NoExtractor, SQL}

class CharacterAffiliationSQLProvider {

  def selectByCharacterId(CharacterId:Long):SQL[Nothing,NoExtractor] =
  SQL(
  """
    |SELECT `company_id`
    |FROM
    | `character_affiliation`
    | WHERE
    | `character_id` = /*'character_id*/1
  """.stripMargin
  ).bindByName('character_id -> CharacterId)

}