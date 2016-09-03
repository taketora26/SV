package siliconValley.domain.company.model

class Company(
               val id: Long,
               val name: String,
               val companyProductId: Int
             )

object Company {
  def apply(id: Long, name: String, companyProductId: Int) =
    new Company(
      id = id,
      name = name,
      companyProductId = companyProductId
    )
}

