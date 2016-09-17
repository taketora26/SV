package siliconValley.controllers.character

import siliconValley.application.characterProfile.model.CharacterProfile
import siliconValley.application.characters.form.CharacterForm
import siliconValley.application.characters.model.Characters
import siliconValley.domain.character.repository.CharacterRepository
import play.api.mvc.{Action, Controller}

class CharacterController extends Controller {

  val characterRepository = new CharacterRepository

  def showCharacterList = Action { implicit request =>
    val charactersResponse = characterRepository.resolveAll.getOrElse(Seq.empty)
    println(charactersResponse)
    val characters = charactersResponse.map { character =>
      Characters(character)
    }
    Ok(siliconValley.views.html.characterlist(characters))
  }

  def showCharacterProfile  = Action { implicit request =>
    val characterId = 1
    val character = characterRepository.resolveById(characterId).get.get
    val charactersProfile = CharacterProfile(character)

    Ok(siliconValley.views.html.characterProfileList(charactersProfile))
  }
}