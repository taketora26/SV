package siliconValley.domain.character.model

import play.api.libs.json.{Json, Writes}

class Character(
                 val id: Long,
                 val name: String,
                 val fullName: String,
                 val realName: String,
                 val roleId: Int,
                 val skill: String,
                 val imageUrl: String
               )

object Character {

  implicit val CharacterWrite: Writes[Character] = Json.writes[Character]

  def apply(id: Long, name: String, fullName: String, realName: String, roleId: Int, skill: String, imageUrl: String) =
    new Character(
      id = id,
      name = name,
      fullName = fullName,
      realName = realName,
      roleId = roleId,
      skill = skill,
      imageUrl = imageUrl
    )

  def unapply(character:Character): Option[(Long,String,String,String,Int,String,String)] =
    Some(
      character.id,
      character.name,
      character.fullName,
      character.realName,
      character.roleId,
      character.skill,
      character.imageUrl
    )

}

