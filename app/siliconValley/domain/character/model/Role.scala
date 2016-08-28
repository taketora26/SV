package siliconValley.domain.character.model

import play.api.libs.json.{Json, Writes}

sealed abstract class Role(val value: Int)

object Role {

  implicit val roleWrite: Writes[Role] = Json.writes[Role]

  case object Programmer extends Role(1)

  case object BackOffice extends Role(2)

  case object BoardMember extends Role(3)

  case object President extends Role(4)

  case object Incubator extends Role(5)

  case object Assistant extends Role(6)

  def apply(value: Int): Role = {
    value match {
      case 1 => Programmer
      case 2 => BackOffice
      case 3 => BoardMember
      case 4 => President
      case 5 => Incubator
      case 6 => Assistant
    }
  }


  def unapply(role: Role): Option[Int] = Some(role.value)

}