package siliconValley.application.characters.model

import siliconValley.domain.character.model.Role
import siliconValley.domain.character.model.Character

case class Characters(
                       id: Long,
                       name: String,
                       fullName: String,
                       realName: String,
                       role: Role,
                       skill: String,
                       imageUrl: String
                     )

object Characters {
  def apply(
             character: Character
           ): Characters = {
    Characters(
        character.id,
        character.name,
        character.fullName,
        character.realName,
        Role.valueToObject(character.roleId),
        character.skill,
        character.imageUrl
    )
  }
}