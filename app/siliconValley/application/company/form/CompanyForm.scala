package siliconValley.application.company.form

import play.api.data.Form
import play.api.data.Forms._

object CompanyForm {

  case class CompanyFormData(CompanyName: String, productName: String, productDetail: String, ImageUrl: String)

  def form = Form(
    mapping(
      "company_name" -> nonEmptyText,
      "product_name" -> nonEmptyText,
      "product_detail" -> nonEmptyText,
      "image_url" -> nonEmptyText
    )(CompanyFormData.apply)(CompanyFormData.unapply)
  )

}