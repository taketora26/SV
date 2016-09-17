package siliconValley.domain.company.repository

import scalikejdbc.{WrappedResultSet, AutoSession, DBSession}
import siliconValley.domain.company.model.Company
import siliconValley.infra.rdbms.CompanySQLProvider

import scala.util.Try

class CompanyRepository(
                         val companySQLProvider: CompanySQLProvider = new CompanySQLProvider
                       )(
                         implicit val session: DBSession = AutoSession
                       ) {

  def resolveById(id: Long): Try[Option[Company]] = Try {
    companySQLProvider.selectById(id).map(wrappedResultSet).single().apply()
  }

  private def wrappedResultSet(rs: WrappedResultSet): Company = {
    Company(
      id = rs.long("id"),
      name = rs.string("name"),
      companyProductId = rs.int("company_product_id")
    )
  }
}