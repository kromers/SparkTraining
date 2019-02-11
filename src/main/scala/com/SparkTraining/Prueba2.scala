package com.SparkTraining

class Prueba2 {

}


object Prueba2 extends App {

  def divide : Unit = {
    try {
      val dividend = Console.readLine("Enter an Int that you'd like to divide:\n").toInt
      val divisor = Console.readLine("Enter an Int that you'd like to divide by:\n").toInt
      val result = dividend / divisor
      println("Result of " + dividend + "/"+ divisor +" is: " + result)
    } catch {
      case e: Exception =>
        println("You must've divided by zero or entered something that's not an Int. Try again!")
        println("Info from the exception: " + e.getMessage)
        divide
    }
  }

  divide

}