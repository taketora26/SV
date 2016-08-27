package siliconValley.domain.character.model

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

}

