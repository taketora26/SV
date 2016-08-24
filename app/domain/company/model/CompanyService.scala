package domain.company.model

class CompanyService(
                      val id: Long,
                      val name: String,
                      val detail: String
                    )

object CompanyService {
  def apply(id: Long, name: String, detail: String) =
    new CompanyService(
      id = id,
      name = name,
      detail = detail
    )
}