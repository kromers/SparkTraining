package com.SparkTraining

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import scala.util.{Try, Success, Failure}

/**
 * Hello world!
 *
 */
object SortProblem extends App {
  println( "Hello World!" )

  Logger.getLogger("org").setLevel(Level.ERROR)
  val conf = new SparkConf().setAppName("SortProblem").setMaster("local[*]")
  val sc = new SparkContext(conf)

  //val lines = sc.textFile("in/RealEstate.csv")

  divide

  def divide: Try[Int] = {
    val dividend = Try(Console.readLine("Enter an Int that you'd like to divide:\n").toInt)
    val divisor = Try(Console.readLine("Enter an Int that you'd like to divide by:\n").toInt)

    val problem = dividend.flatMap(x => divisor.map(y => x/y))
    problem match {
      case Success(v) =>
        //println("Result of " + dividend.get + "/"+ divisor.get +" is: " + v)
        println("Result of " + dividend.get + "/"+ divisor.get +" is: " + v)
        Success(v)
      case Failure(e) =>
        println("You must've divided by zero or entered something that's not an Int. Try again!")
        println("Info from the exception: " + e.getMessage)
        divide
    }
  }

}


