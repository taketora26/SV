package siliconValley.domain.company.model

class CompanyProduct(
                      val id: Long,
                      val name: String,
                      val detail: String
                    )

object CompanyProduct {
  def apply(id: Long, name: String, detail: String) =
    new CompanyProduct(
      id = id,
      name = name,
      detail = detail
    )
}