package siliconValley.controllers.api

import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import siliconValley.application.characters.model.Characters
import siliconValley.domain.character.repository.CharacterRepository

class CharacterApiController extends Controller {

  val characterRepository = new CharacterRepository

  def charactersApi = Action { implicit request =>
    val charactersResponse = characterRepository.resolveAll.getOrElse(Seq.empty)
    println(charactersResponse)
    val characters = charactersResponse.map { character =>
      Characters(character)
    }

    val data = Json.toJson(characters)

    Ok(data)
  }

}

