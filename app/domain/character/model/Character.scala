package domain.character.model

class Character(
                 val id: Long,
                 val name: String,
                 val fullName: String,
                 val realName: String,
                 val role: Role,
                 val skill: String,
                 val imageUrl: String
               )

object Character {
  def apply(id: Long, name: String, fullName: String, realName: String, role: Role, skill: String, imageUrl: String) =
    new Character(
      id = id,
      name = name,
      fullName = fullName,
      realName = realName,
      role = role,
      skill = skill,
      imageUrl = imageUrl
    )
}

