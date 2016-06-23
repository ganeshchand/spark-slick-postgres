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
  "com.typesafe.slick" %% "slick" % "3.1.1",
  "com.h2database" % "h2" % "1.4.185",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "ch.qos.logback" % "logback-classic" % "1.1.7", // for logging
  "org.apache.spark" % "spark-core_2.11" % "1.6.1",
  "org.apache.spark" % "spark-sql_2.11" % "1.6.1",
  "org.apache.spark" % "spark-streaming_2.11" % "1.6.1"
)
    