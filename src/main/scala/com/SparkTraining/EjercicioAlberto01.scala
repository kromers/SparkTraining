package com.SparkTraining

import java.io.PrintWriter

class EjercicioAlberto01 {




}


object Solution {

  /*
   * Complete the simpleArraySum function below.
   */
  def simpleArraySum(ar: Array[Int]): Int = {
    if (ar.isEmpty) {
      0
    }else{
      ar.head + simpleArraySum(ar.tail)
    }
  }

  def main(args: Array[String]){
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val arCount = stdin.readLine.trim.toInt

    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = simpleArraySum(ar)

    println(result)

    printWriter.println(result)

    printWriter.close()
  }
}

