package infra.rdbms

import org.specs2.mutable.Specification

class CharacterSQLProviderSpecs extends Specification
with WithTestTable {

  override protected val testTableName: String = "characters"

  sequential

  val characterSQLProvider = new CharacterSQLProvider

  "CharacterSQLProvider" >> {

    "テーブル全体の読み取り(selectAll)ができる" >> {
      withSession {

        //selectAllする
        val actual = characterSQLProvider.selectAll.map(rs => (
          rs.int("id"),
          rs.string("name"),
          rs.string("full_name"),
          rs.string("real_name"),
          rs.int("role_id"),
          rs.string("skill"),
          rs.string("image_url")
          )).list().apply()

        println(actual.head._2)

        actual.head._2 must beEqualTo("リチャード")

      }
    }
  }
}



