package siliconValley.domain.company.model

class Company(
               val id: Long,
               val name: String,
               val companyProductId: Int,
               val imageUrl: String
             )

object Company {
  def apply(id: Long, name: String, companyProductId: Int,imageUrl:String) :Company =
    new Company(
      id = id,
      name = name,
      companyProductId = companyProductId,
      imageUrl = imageUrl
    )
}

