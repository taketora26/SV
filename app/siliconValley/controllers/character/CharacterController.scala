package siliconValley.controllers.character

import siliconValley.application.characters.model.Characters
import siliconValley.domain.character.repository.CharacterRepository
import play.api.mvc.{Action, Controller}

class CharacterController extends Controller {

  val characterRepository = new CharacterRepository

  def list = Action { implicit request =>
    val charactersResponse = characterRepository.resolveAll.getOrElse(Seq.empty)
    println(charactersResponse)
    val characters = charactersResponse.map { character =>
      Characters(character)
    }
    Ok(siliconValley.views.html.list(characters))
  }
}