package siliconValley.infra.rdbms

import org.specs2.mutable.Specification
import siliconValley.domain.company.model.Company

class CompanySQLProviderSpecs extends Specification
with WithTestTable {

  override protected val testTableName: String = "company"

  sequential

  val companySQLProvider = new CompanySQLProvider

  "CompanySQLProvider" >> {

    "読み取り(select)ができる" >> {
      withSession {

        val companyId: Long = 1

        //selectする
        val actual = companySQLProvider.selectById(companyId)
          .map(rs => (
            rs.int("id"),
            rs.string("name"),
            rs.int("company_product_id")
            )).list().apply()

        val expectCompany = new Company(1,"PiedPiper",1)

      actual.head._2 === expectCompany.name
      }
    }
  }
}