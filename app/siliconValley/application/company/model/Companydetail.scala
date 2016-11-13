package siliconValley.application.company.model

import play.api.libs.json.{Json, Writes}
import siliconValley.domain.company.model.{Company, CompanyProduct}

case class CompanyDetail(
                          id: Long,
                          name: String,
                          productName: String,
                          productDetail: String,
                          imageUrl: String
                        )

object CompanyDetail {

  implicit val CompanyDetailWrite: Writes[CompanyDetail] = Json.writes[CompanyDetail]

  def apply(
             company: Company,
             companyProduct: CompanyProduct
           ): CompanyDetail = {
    CompanyDetail(
      company.id,
      company.name,
      companyProduct.name,
      companyProduct.detail,
      company.imageUrl
    )
  }

}