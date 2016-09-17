package siliconValley.domain.company.repository

import org.specs2.mutable.Specification
import siliconValley.domain.company.model.CompanyProduct
import siliconValley.infra.rdbms.WithTestTable

import scala.util.Try


class CompanyProductRepositorySpecs extends Specification
with WithTestTable {

  override protected val testTableName: String = "company_product"

  sequential

  val companyProductRepository = new CompanyProductRepository

  "CompanyProductRepository" >> {
    "読み取り(select)ができる" >> {
      withSession {

        val companyProductId = 1L

        val resolveBy: Try[List[CompanyProduct]] = companyProductRepository.resolveById(companyProductId)

        val expecCompanyProduct = new CompanyProduct(1, "PiedPiper", "圧縮ソフトウェア")

        resolveBy must beSuccessfulTry

        resolveBy.get.head.name ==== expecCompanyProduct.name
      }
    }
  }
}