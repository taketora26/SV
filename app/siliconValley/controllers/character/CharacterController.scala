package siliconValley.controllers.character

import siliconValley.application.characterProfile.model.CharacterProfile
import siliconValley.application.characters.form.CharacterForm
import siliconValley.application.characters.model.Characters
import siliconValley.domain.character.repository.CharacterRepository
import siliconValley.domain.company.repository.CompanyRepository
import play.api.mvc.{Action, Controller}
import siliconValley.application.characters.form.CharacterForm.CharacterFormData
import siliconValley.domain.character.model.{Character, Role}


class CharacterController extends Controller {

  val characterRepository = new CharacterRepository
  // val companyRepository = mew CompanyRepository

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
    Ok(siliconValley.views.html.newCharacter())
  }

  def createCharacter = Action { implicit request =>
    CharacterForm.form.bindFromRequest.fold(
      errors => BadRequest("入力ミス"),
      CharacterFormData => {
        val checkNewCharacter = characterRepository.resolveByName(CharacterFormData.name).getOrElse(None)
        checkNewCharacter match {
          case Some(u) =>  BadRequest("すでに登録されています")
          case None => characterRepository.store(CharacterFormData.name,CharacterFormData.fullName,CharacterFormData.realName,CharacterFormData.roleId,CharacterFormData.skill,CharacterFormData.image_url)
            Redirect("/characters/list")
        }

      })
  }



//    CharacterForm.form.bindFromRequest.fold(
//
//      errors => BadRequest(views.html.newCharacter("入力ミス"))
//
//      CharacterFormData => {
//        val newCharacter = characterRepository.resolveByName(CharacterFormData.name).getOrElse(None)
//
//        newCharacter match {
//          case Some(Character) => BadRequest(views.html.newCharacter("入力ミス"))
//          case _ => characterRepository
//        }
//      })
//  }
}