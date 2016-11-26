package siliconValley.controllers.character

import play.api.mvc.{Action, Controller}
import siliconValley.application.characterProfile.model.CharacterProfile
import siliconValley.application.characters.form.CharacterForm
import siliconValley.application.characters.model.Characters
import siliconValley.domain.character.repository.{CharacterAffiliationRepository, CharacterRepository}
import siliconValley.domain.company.repository.CompanyRepository


class CharacterController extends Controller {

  val characterRepository = new CharacterRepository
  val companyRepository = new CompanyRepository
  val characterAffiliationRepository = new CharacterAffiliationRepository

  def showCharacterList = Action { implicit request =>
    lazy val charactersResponse = characterRepository.resolveAll.getOrElse(Seq.empty)
    println(charactersResponse)
    lazy val characters = charactersResponse.map { character =>
      Characters(character)
    }
    Ok(siliconValley.views.html.characterList(characters))
  }

  def showCharacterProfile(characterId: Long) = Action { implicit request =>
    lazy val character = characterRepository.resolveById(characterId).get.get
    lazy val charactersProfile = CharacterProfile(character)

    Ok(siliconValley.views.html.characterProfileList(charactersProfile))
  }

  def createCharacterForm = Action { implicit request =>
    lazy val companies = companyRepository.resolveAll.get
    Ok(siliconValley.views.html.newCharacter(companies))
  }

  def createCharacter = Action { implicit request =>
    CharacterForm.form.bindFromRequest.fold(
      errors => BadRequest("入力ミス"),
      CharacterFormData => {
       lazy val company = companyRepository.resolveById(CharacterFormData.company).getOrElse(None)
       lazy val checkNewCharacter = characterRepository.resolveByName(CharacterFormData.name).getOrElse(None)
        checkNewCharacter match {
          case Some(u) => BadRequest("すでに登録されています")
          case None =>
            val characterId:Long= characterRepository.store(CharacterFormData.name, CharacterFormData.fullName, CharacterFormData.realName, CharacterFormData.roleId, CharacterFormData.skill, CharacterFormData.image_url).get
            characterAffiliationRepository.store(company.get.id,characterId)
            Redirect("/characters/list")
        }
      })
  }

}