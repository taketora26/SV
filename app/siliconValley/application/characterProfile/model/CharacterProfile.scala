package siliconValley.application.characterProfile.model

import play.api.libs.json.{Json, Writes}
import siliconValley.domain.character.model.{Character, Role}
import siliconValley.domain.company.model.Company

case class CharacterProfile(
                             id: Long,
                             name: String,
                             fullName: String,
                             realName: String,
                             role: Role,
                             skill: String,
                             imageUrl: String,
                             companyName: String,
                             companyProductName: String,
                             companyProductDetail: String
                             //                             phrase_english:String, todo Phrase modelを作成後
                             //                             phrase_japanese:String todo Phrase modelを作成後
                           )

object CharacterProfile {

  implicit val CharacterProfileWrite: Writes[CharacterProfile] = Json.writes[CharacterProfile]

//  def apply(
//             character: Character
//           ): CharacterProfile = {
//    CharacterProfile(
//      character.id,
//      character.name,
//      character.fullName,
//      character.realName,
//      Role.apply(character.roleId),
//      character.skill,
//      character.imageUrl
//    )

//  }

  //2.Company

//  private def searchCompany(character:Character):Company = {
    // CharacterAffiliationのテーブルを見てcharacter_idから、company_idを引っ張る。
    //
//  }

//  private def searchCompanyProduct(company:Company) = {
//  }

}