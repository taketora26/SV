package siliconValley.application.characters.form

import play.api.data.Form
import play.api.data.Forms._

object CharacterForm {

  case class CharacterFormFactor(name:String, full_name:String, real_name:String, role:String, skill:String, image_url:String)

  def form = Form(
    mapping(
    "name" -> nonEmptyText,
    "full_name" -> text,
    "real_name" -> text,
    "role" -> nonEmptyText,
    "skill" -> text,
    "image_url" -> text
    )(CharacterFormFactor.apply)(CharacterFormFactor.unapply)
  )


}