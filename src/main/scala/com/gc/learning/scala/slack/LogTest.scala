package com.gc.learning.scala.slack

import org.slf4j.LoggerFactory

/**
  * Created by ganeshchand on 6/22/16.
  */
object LogTest extends App{
  def logger = LoggerFactory.getLogger(this.getClass)

  println("Starting to write log")
  logger.info("Just an FYI..I am logging everything!")

}
