package siliconValley.domain.company.repository

import scalikejdbc.{WrappedResultSet, AutoSession, DBSession}
import siliconValley.domain.company.model.{Company, CompanyProduct}
import siliconValley.infra.rdbms.CompanyProductSQLProvider

import scala.util.Try

class CompanyProductRepository(
                                val companyProductSQLProvider: CompanyProductSQLProvider = new CompanyProductSQLProvider
                              )(
                                implicit val session: DBSession = AutoSession
                              ) {

  def resolveById(id: Long): Try[Option[CompanyProduct]] = Try {
    companyProductSQLProvider.selectById(id).map(wrappedResultSet).single().apply()
  }

  private def wrappedResultSet(rs: WrappedResultSet): CompanyProduct = {
    CompanyProduct(
      id = rs.long("id"),
      name = rs.string("name"),
      detail = rs.string("detail")
    )
  }
}