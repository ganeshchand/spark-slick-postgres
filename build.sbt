name := "spark-slack-postgres"

version := "1.0"

scalaVersion := "2.11.8"

val majorScalaVersion = "2.11"
val sparkVersion = "1.6.1"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-unchecked",
  "-feature",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-Ywarn-dead-code",
  "-Xlint",
  "-Xfatal-warnings"
)

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.7", // for logging
  "com.h2database" % "h2" % "1.4.185",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "com.typesafe.slick" %% "slick" % "3.1.1",
  "org.apache.spark" % "spark-core_2.11" % "1.6.1",

  // to resole multiple version conflicts with spark dependency
  "org.scala-lang" % "scala-compiler" % "2.11.8",
  "org.scala-lang" % "scala-reflect" % "2.11.8",
  "org.apache.commons" % "commons-lang3" % "3.3.2",
  "jline" % "jline" % "0.9.94",
  "org.scala-lang.modules" % "scala-parser-combinators_2.11" % "1.0.4",
 "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4"
)

