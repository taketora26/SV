package siliconValley.infra.rdbms

import scalikejdbc.{NoExtractor, SQL}

class CharacterAffiliationSQLProvider {

  def selectByCharacterId(CharacterId: Long): SQL[Nothing, NoExtractor] =
    SQL(
      """
        |SELECT `company_id`
        |FROM
        | `character_affiliation`
        | WHERE
        | `character_id` = /*'character_id*/1
      """.stripMargin
    ).bindByName('character_id -> CharacterId)

  def insert(companyId: Long, characterId: Long): SQL[Nothing, NoExtractor] =
    SQL(
      """
        |INSERT INTO `character_affiliation`
        |(
        |`company_id`,
        |`character_id`
        |)
        |VALUES (
        |/*'company_id*/0,
        |/*'character_id*/0
        |)
      """.stripMargin
    ).bindByName(
      'company_id -> companyId,
      'character_id -> characterId
    )

}