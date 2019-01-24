package com.SparkTraining

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

/* Create a Spark program to read the house data from in/RealEstate.csv,
       output the average price for houses with different number of bedrooms.

    The houses dataset contains a collection of recent real estate listings in San Luis Obispo county and
    around it. 

    The dataset contains the following fields:
    1. MLS: Multiple listing service number for the house (unique ID).
    2. Location: city/town where the house is located. Most locations are in San Luis Obispo county and
    northern Santa Barbara county (Santa Maria­Orcutt, Lompoc, Guadelupe, Los Alamos), but there
    some out of area locations as well.
    3. Price: the most recent listing price of the house (in dollars).
    4. Bedrooms: number of bedrooms.
    5. Bathrooms: number of bathrooms.
    6. Size: size of the house in square feet.
    7. Price/SQ.ft: price of the house per square foot.
    8. Status: type of sale. Thee types are represented in the dataset: Short Sale, Foreclosure and Regular.

    Each field is comma separated.

    Sample output:

       (3, 325000)
       (1, 266356)
       (2, 325000)
       ...

       3, 1 and 2 mean the number of bedrooms. 325000 means the average price of houses with 3 bedrooms is 325000.
     */
object SortProblem extends App {
  println( "SortProblem!" )

  Logger.getLogger("org").setLevel(Level.ERROR)
  val conf = new SparkConf().setAppName("SortProblem").setMaster("local[*]")
  val sc = new SparkContext(conf)

  val lines = sc.textFile("in/RealEstate.csv")

  // Eliminamos la primera línea que es la cabecera
  val noHeadLines = lines.filter(l => !l.contains("MLS"))


  // Creamos un nuevo RDD que contiene solo número de habitaciones (columna 4)y el precio de la vivienda (columna 3)
  // Casteamos la columna 4 a entero y la columna 3 a Double
  val housePriceLine = noHeadLines.map(line => (line.split(",")(3).toInt,(1,line.split(",")(2).toDouble)))


  // Contamos las casas que tienen una sola habitacion, las que tienen 2 habitaciones, ....
  val housePrice = housePriceLine.reduceByKey((x,y) => (x._1 + y._1,x._2 + y._2))


  val avgHousePrice = housePrice.map((x) => (x._1, mediaMap(x._2._1,x._2._2)))



  avgHousePrice.take(5).foreach(println)

  def mediaMap(contador:Int, total:Double): Double ={
    total/contador
  }

}
