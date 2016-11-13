package siliconValley.controllers.company

import play.api.mvc.{Action, Controller}
import siliconValley.application.company.form.CompanyForm
import siliconValley.application.company.form.CompanyForm.CompanyFormData
import siliconValley.domain.company.repository.CompanyRepository
import siliconValley.domain.companyProduct.repository.CompanyProductRepository


class CompanyController extends Controller {

  val companyRepository = new CompanyRepository
  val companyProductRepository = new CompanyProductRepository


  def createCompanyForm = Action { implicit request =>
    Ok(siliconValley.views.html.newCompany())
  }

  def createCompany = Action { implicit request =>
    CompanyForm.form.bindFromRequest.fold(
      errors => BadRequest("入力ミス"),
      CompanyFormData => {
        lazy val company = companyRepository.resolveByName(CompanyFormData.CompanyName).getOrElse(None)
        company match {
          case Some(c) => BadRequest("すでに登録されています")
          case None =>
            val companyProductId: Long = companyProductRepository.store(CompanyFormData.productName, CompanyFormData.productDetail).get
            companyRepository.store(CompanyFormData.CompanyName, companyProductId, CompanyFormData.ImageUrl)
            Redirect("/characters/create ")
        }
      }
    )
  }

}