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

}