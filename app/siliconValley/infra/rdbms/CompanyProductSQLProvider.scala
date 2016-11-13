package siliconValley.infra.rdbms

import scalikejdbc.{NoExtractor, SQL}

class CompanyProductSQLProvider {

  def selectById(CompanyId:Long):SQL[Nothing,NoExtractor] =
  SQL(
    """
      |SELECT *
      |FROM
      | `company_product`
      | WHERE
      | `id` = /*'id*/1
    """.stripMargin
  ).bindByName('id -> CompanyId)

  def insert(name:String,detail:String): SQL[Nothing, NoExtractor] =
    SQL(
      """
        |INSERT INTO `company_product`
        |(
        |`name`,
        |`detail`
        |)
        |VALUES (
        |/*'name*/name,
        |/*'detail*/'detail'
        |)
      """.stripMargin
    ).bindByName(
      'name -> name,
      'detail -> detail
    )

}