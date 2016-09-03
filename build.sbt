import org.flywaydb.sbt.FlywayPlugin._

name := """SiliconValley"""

version := "1.0-SNAPSHOT"

lazy val siliconValley = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "org.scalikejdbc" %% "scalikejdbc" % "2.3.1",
  "org.scalikejdbc" %% "scalikejdbc-test" % "2.3.+",
  "org.scalikejdbc" %% "scalikejdbc-config" % "2.3.1",
  "org.scalikejdbc" %% "scalikejdbc-play-plugin" % "2.3.6",
  "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.4.3",
  "mysql" % "mysql-connector-java" % "5.1.33",
  "org.json4s" % "json4s-native_2.11" % "3.4.0"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

routesGenerator := InjectedRoutesGenerator

flywaySettings
