package com.SparkTraining

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

class DiagonalDifference {

}


object Solucion {

  // Complete the diagonalDifference function below.
  def diagonalDifference(arr: Array[Array[Int]]): Int = {
    var diagonalPpal = 0
    var diagonalSec = 0
    val long = arr.length - 1
   for(  i <- 0 until long + 1){
      diagonalPpal = diagonalPpal + arr(i)(i)
      diagonalSec = diagonalSec + arr(i)(long - i)
    }
    (diagonalPpal - diagonalSec).abs
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val arr = Array.ofDim[Int](n, n)

    for (i <- 0 until n) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = diagonalDifference(arr)

    printWriter.println(result)

    printWriter.close()

    println("El resultado es: " + result)
  }
}

