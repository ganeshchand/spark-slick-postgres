package com.gc.learning.scala.slack

import org.slf4j.LoggerFactory
import slick.driver.H2Driver.api._

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by ganeshchand on 6/22/16.
  */

object SlickExample extends App {

  def logger = LoggerFactory.getLogger(this.getClass)
  logger.info("Slick Example Running")

  // case class representing a row in our table
  final case class Message(
                            sender: String,
                            content: String,
                            id: Long = 0L
                          )

  // define a schema for the message table

  final class MessageTable(tag: Tag) extends Table[Message](tag, "message") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def sender = column[String]("sender")

    def content = column[String]("content")

    def * = (sender, content, id) <>(Message.tupled, Message.unapply _)
  }


  // a helper method to create a few test Messages for Demo
  def freshTestData = Seq(
    Message("Dave", "Hello, HAL. Do you read me, HAL?"),
    Message("HAL", "Hello, Dave. I read youy"),
    Message("Dave", "Open the doors, HAL"),
    Message("HAL", "I'm sorry, Dave. I can't do that now.")
  )


  // Base query for querying the messages table:

  lazy val messages = TableQuery[MessageTable] // similar to SELECT *

  // An example of a uery that selects a subset of messages

  val halSays = messages.filter(_.sender === "HAL") // applying predicate on base query

  // create an in-memory H2 database

  val db = Database.forConfig("SlickExampleDemo")


  // Helper method for running a query in this example file:

  def exec[T](program: DBIO[T]): T =
    Await.result(db.run(program), 2 seconds)

  logger.info("Creating the message table")
  exec(messages.schema.create) // action
  logger.info(s"Created a table with the following schema:\n ${messages.schema.createStatements.mkString}")

  logger.info("Inserting test data")
  exec(messages ++= freshTestData)

  logger.info("Running a query that selects all rows")
  exec(messages.result).foreach(println)


  logger.info("Selecting only messages from HAL")
  exec(halSays.result).foreach(println)


  logger.info("Inserting a new record")
  exec(messages.insertOrUpdate(Message("Admin", "Hello all, this is a new record.")))

  logger.info("Displaying the latest record")
  exec(messages.result).foreach(println)

}




