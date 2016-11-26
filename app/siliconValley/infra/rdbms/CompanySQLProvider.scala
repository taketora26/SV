package siliconValley.infra.rdbms

import scalikejdbc.{NoExtractor, SQL}

class CompanySQLProvider {

  def selectAll: SQL[Nothing, NoExtractor] =
    SQL( """SELECT * FROM `company`""")

  def selectById(id: Long): SQL[Nothing, NoExtractor] =
    SQL(
      """
        |SELECT *
        |FROM
        | `company`
        | WHERE
        | `id` = /*'id*/1
      """.stripMargin
    ).bindByName('id -> id)

  def selectByName(name: String): SQL[Nothing, NoExtractor] =
    SQL(
      """
        |SELECT *
        |FROM
        | `company`
        | WHERE
        | `name` = /*'name*/name
      """.stripMargin
    ).bindByName('name -> name)

  def insert(name: String, companyProductId: Long, imageUrl: String): SQL[Nothing, NoExtractor] =
    SQL(
      """
        |INSERT INTO `company`
        |(
        |`name`,
        |`company_product_id`,
        |`image_url`
        |)
        |VALUES (
        |/*'name*/name,
        |/*'company_product_id*/'company_product_id',
        |/*'image_url*/'image_url'
        |)
      """.stripMargin
    ).bindByName(
      'name -> name,
      'company_product_id -> companyProductId,
      'image_url -> imageUrl
    )


}