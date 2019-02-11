package com.SparkTraining

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.util.{Failure, Success, Try}

/**
 * Hello world!
 *
 */
object SortProblem extends App {
  println( "Ejemplo de Excepciones" )

  Logger.getLogger("org").setLevel(Level.ERROR)
  val conf = new SparkConf().setAppName("SortProblem").setMaster("local[*]")
  val sc = new SparkContext(conf)

  //val lines = sc.textFile("in/RealEstates.csv")

  val lines = leerFichero("in/RealEstate.csv")

  lines.take(5).foreach(println)

  def leerFichero(path: String): RDD[String] = {
    Try(sc.textFile(path)) match {
      case Success(a) =>
        println("Existe el fichero")
        a
      case Failure(e) =>
        println("Error (no existe el fichero): " + e.getMessage)
        Failure(e).get

    }

  }

}


