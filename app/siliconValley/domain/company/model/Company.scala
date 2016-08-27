package siliconValley.domain.company.model

class Company(
               val id: Long,
               val name: String,
               val companyServiceId: Int
             )

object Company {
  def apply(id: Long, name: String, companyServiceId: Int) =
    new Company(
      id = id,
      name = name,
      companyServiceId = companyServiceId
    )
}

