package siliconValley.infra.rdbms

import scalikejdbc.{NoExtractor, SQL}

class CharacterSQLProvider {

  def selectAll: SQL[Nothing, NoExtractor] =
    SQL( """SELECT * FROM `characters`""")

  def selectByName(name: String): SQL[Nothing, NoExtractor] =
    SQL(
      """
        |SELECT *
        |FROM
        | `characters`
        | WHERE
        | `name` = /*'name*/'name'
      """.stripMargin
    ).bindByName('name -> name)

  def selectById(id: Long): SQL[Nothing, NoExtractor] =
    SQL(
      """
        |SELECT *
        |FROM
        | `characters`
        | WHERE
        | `id` = /*'id*/'id'
      """.stripMargin
    ).bindByName('id -> id)

  def insert(name: String, fullName: String, realName: String, roleId: Int, skill: String, imageUrl: String): SQL[Nothing, NoExtractor] =
    SQL(
      """
        |INSERT INTO `characters`
        |(
        |`name`,
        |`full_name`,
        |`real_name`,
        |`role_id`,
        |`skill`,
        |`image_url`
        |)
        |VALUES (
        |/*'name*/name,
        |/*'full_name*/'full_name',
        |/*'real_name*/'real_name',
        |/*'role_id*/1,
        |/*'skill*/'skill',
        |/*'image_url*/'image_url'
        |)
      """.stripMargin
    ).bindByName(
      'name -> name,
      'full_name -> fullName,
      'real_name -> realName,
      'role_id -> roleId,
      'skill -> skill,
      'image_url -> imageUrl
    )


  //  def insert(email: String, password: String, fullName: String): SQL[Nothing, NoExtractor] =
  //    SQL(
  //      """
  //        |INSERT INTO `users`
  //        |(
  //        |  `email`,
  //        |  `password`,
  //        |  `fullname`
  //        |)
  //        |VALUES (
  //        |/*'email*/1,
  //        |/*'password*/'password',
  //        |/*'fullname*/'fullName'
  //        |)
  //      """.stripMargin
  //    ).bindByName(
  //      'email -> email,
  //      'password -> password,
  //      'fullname -> fullName
  //    )


}