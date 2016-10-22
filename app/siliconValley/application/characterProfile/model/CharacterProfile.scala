package siliconValley.application.characterProfile.model

import play.api.libs.json.{Json, Writes}
import siliconValley.domain.character.model.{Character, Role}
import siliconValley.domain.character.repository.CharacterAffiliationRepository
import siliconValley.domain.company.model.{CompanyProduct, Company}
import siliconValley.domain.company.repository.{CompanyProductRepository, CompanyRepository}

import scala.util.{Failure, Success}

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

    def apply(
               character: Character
             ): CharacterProfile = {
      CharacterProfile(
        character.id,
        character.name,
        character.fullName,
        character.realName,
        Role.apply(character.roleId),
        character.skill,
        character.imageUrl,
        searchCompany(character).name,
        searchCompanyProduct(searchCompany(character)).name,
        searchCompanyProduct(searchCompany(character)).detail
      )
    }


  val characterAffiliationRepository:CharacterAffiliationRepository = new CharacterAffiliationRepository
  val companyRepository:CompanyRepository = new CompanyRepository
  val companyProductRepository = new CompanyProductRepository

    private def searchCompany(character:Character):Company = {

      val companyId:Long = characterAffiliationRepository.resolveCompanyIdByCharacterId(character.id) match {
        case Success(r) => r match {
          case Some(id) => id
          case None => 0
        }
        case Failure(e) => throw new IllegalArgumentException(s"登録さてていないキャラクターIDです。: ${character.id}.")
      }

      companyRepository.resolveById(companyId) match {
        case Success(r) => r match {
          case Some(company) => company
          case None => new Company(0,"",0)
        }
        case Failure(e) => throw new IllegalArgumentException
      }
    }

    private def searchCompanyProduct(company:Company):CompanyProduct = {
      companyProductRepository.resolveById(company.companyProductId) match {
        case Success(r) => r match {
          case Some(companyProduct) => companyProduct
          case None => new CompanyProduct(0,"","")
        }
        case Failure(e) => throw new IllegalArgumentException
      }
    }

}
