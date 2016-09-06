package siliconValley.domain.company.repository

import org.specs2.mutable.Specification
import siliconValley.domain.company.model.Company
import siliconValley.infra.rdbms.WithTestTable

import scala.util.Try


class CompanyRepositorySpecs extends Specification
with WithTestTable {

  override protected val testTableName: String = "company"

  sequential

  val companyRepository = new CompanyRepository

  "CompanyRepository" >> {
    "読み取り(select)ができる" >> {
      withSession {

        val companyId: Long = 1
        val resolveBy: Try[List[Company]] = companyRepository.resolveById(companyId)

        val expectName = "PiedPiper"

        resolveBy must beSuccessfulTry
        resolveBy.get.head.name must beEqualTo(expectName)

      }
    }
  }
}

