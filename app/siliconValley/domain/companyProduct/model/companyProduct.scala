package siliconValley.domain.companyProduct.model

class CompanyProduct(
                      val id: Long,
                      val name: String,
                      val detail: String
                    )

object CompanyProduct {
  def apply(id: Long, name: String, detail: String): CompanyProduct =
    new CompanyProduct(
      id = id,
      name = name,
      detail = detail
    )

}