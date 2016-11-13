package siliconValley.domain.companyProduct.repository

import scalikejdbc.{AutoSession, DBSession, WrappedResultSet}
import siliconValley.domain.company.model.CompanyProduct
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

  def store(name:String,detail: String):Try[Long] = Try {
    companyProductSQLProvider.insert(name,detail).map(wrappedResultSet).updateAndReturnGeneratedKey().apply()
  }

  private def wrappedResultSet(rs: WrappedResultSet): CompanyProduct = {
    CompanyProduct(
      id = rs.long("id"),
      name = rs.string("name"),
      detail = rs.string("detail")
    )
  }
}
