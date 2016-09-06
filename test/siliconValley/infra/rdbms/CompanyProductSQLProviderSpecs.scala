package siliconValley.infra.rdbms

import org.specs2.mutable.Specification
import siliconValley.domain.company.model.CompanyProduct

class CompanyProductSQLProviderSpecs extends Specification
with WithTestTable {

  override protected val testTableName: String = "company_product"

  sequential

  val companyProductSQLProvider = new CompanyProductSQLProvider

  "CompanyProductSQLProvider" >> {

    "読み取り(select)ができる" >> {
      withSession {


        val companyProductId = 2L

        //selectする
        val actual = companyProductSQLProvider.selectById(companyProductId)
          .map(rs => (
            rs.int("id"),
            rs.string("name"),
            rs.string("detail")
            )).list().apply()

        val expectCompanyProduct = new CompanyProduct(1L,"NewClear","圧縮ソフトウェア")

        actual.head._2 ==== expectCompanyProduct.name

      }
    }
  }
}