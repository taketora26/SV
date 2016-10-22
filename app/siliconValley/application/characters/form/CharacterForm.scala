package siliconValley.application.characters.form

import play.api.data.Form
import play.api.data.Forms._
import siliconValley.domain.character.model.Role

object CharacterForm {

case class CharacterFormData(name: String, fullName: String, realName: String, roleId: Int, skill: String, image_url: String, company: String)

  def form = Form(
    mapping(
      "name" -> nonEmptyText,
      "full_name" -> text,
      "real_name" -> text,
      "role" -> number,
      "skill" -> text,
      "image_url" -> text,
      "company" -> text
    )(CharacterFormData.apply)(CharacterFormData.unapply)
  )

}