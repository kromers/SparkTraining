package com.SparkTraining

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Hello world!
 *
 */
object SortProblem extends App {
  println( "Estoy en la rama Desarrollo!" )

  Logger.getLogger("org").setLevel(Level.ERROR)
  val conf = new SparkConf().setAppName("SortProblem").setMaster("local[*]")
  val sc = new SparkContext(conf)

  val lines = sc.textFile("in/RealEstate.csv")

}
