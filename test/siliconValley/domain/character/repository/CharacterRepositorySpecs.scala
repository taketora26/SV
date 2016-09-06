package siliconValley.domain.character.repository

import org.specs2.mutable.Specification
import siliconValley.infra.rdbms.WithTestTable
import siliconValley.domain.character.model.Character
import scala.util.Try

class CharacterRepositorySpecs extends Specification
with WithTestTable {

  override protected val testTableName: String = "characters"

  sequential

  val characterRepository = new CharacterRepository

  "CharacterRepository" >> {

    "テーブル全体の読み取り(resolveAll)ができる" >> {
      withSession {

        val characterAll: Try[List[Character]] = characterRepository.resolveAll

        println(characterAll.get)
        characterAll must beSuccessfulTry
        characterAll.get.head.name must beEqualTo("リチャード")

      }

    }

    "読み取り(select)ができる" >> {
      withSession {

        val characterName:String = "リチャード"
        val resolveBy: Try[Option[Character]] = characterRepository.resolveByName(characterName)

        val expectFullName = "リチャード・ヘンドリックス"

        resolveBy must beSuccessfulTry
        resolveBy.get.get.fullName must beEqualTo(expectFullName)
      }

    }

  }

}



