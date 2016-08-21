package infra.rdbms

import scalikejdbc.config.DBs
import scalikejdbc.{SQL, AutoSession, DBSession}

trait WithTestTable {

  implicit val session: DBSession = AutoSession

  protected val testTableName:String

  def deleteAllTestRecord(): Unit = {
    SQL(
      s"DELETE FROM `$testTableName`"
    ).execute().apply()(session)
    ()
  }

  def withSession[T](f: => T): T = {
    try {
      DBs.setup()
      f
    } finally {
     // deleteAllTestRecord()
      DBs.close()
    }
  }
}
