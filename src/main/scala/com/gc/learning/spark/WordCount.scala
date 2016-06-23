package com.gc.learning.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by ganeshchand on 6/22/16.
  */
object WordCount extends App{
  val conf = new SparkConf()
  conf.setAppName("Sample Word Count")
  conf.setMaster("local[*]")
  val sc = new SparkContext(conf)

  val words = sc.parallelize(Seq("One", "two", "three", "One", "one"))

  words.map(word => (word.toLowerCase,1)).reduceByKey(_ + _).collect.foreach(println)

}
