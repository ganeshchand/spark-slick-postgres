package com.gc.learning.scala.slack

import slick.driver.H2Driver.api._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by ganeshchand on 6/22/16.
  */

object SlickExample extends App {

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

  lazy val messages = TableQuery[MessageTable]


}




