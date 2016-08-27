package siliconValley.domain.character.model

sealed abstract class Role(val value: Int )

object Role {

  case object Programmer extends Role(1)
  case object BackOffice  extends Role(2)
  case object BoardMember extends Role(3)
  case object President extends Role(4)
  case object Incubator extends Role(5)
  case object Assistant extends Role(6)

  def valueToObject(v:Int): Role = {
   v match {
     case 1 => Programmer
     case 2 => BackOffice
     case 3 => BoardMember
     case 4 => President
     case 5 => Incubator
     case 6 => Assistant
   }
  }
}