package siliconValley.application.characters.form

import play.api.data.Form
import play.api.data.Forms._
import siliconValley.domain.character.model.Role

object CharacterForm {

  // フォームの値を格納するケースクラス
case class CharacterFormData(name: String, fullName: String, realName: String, roleId: Int, skill: String, image_url: String, company: Int)

  // formから送信されたデータ ⇔ ケースクラスの変換を行う
  def form = Form(
    mapping(
      "name" -> nonEmptyText,
      "full_name" -> text,
      "real_name" -> text,
      "role" -> number,
      "skill" -> text,
      "image_url" -> text,
      "company" -> number
    )(CharacterFormData.apply)(CharacterFormData.unapply)
  )

}