package com.udemy.scala.programming_in_depth.conditionalStatementDemo

import scala.util.control.Breaks

object DemoCForLoop {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10) {
      println("value of i is " + i)
    }

    for (i <- 1 until 10) {
      println("value of i is using until " + i)
    }

    println("======================Nested For Loop======================")
    // Nested for loop
    for (i <- 1 to 10) {
      for (j <- 1 to 10) {
        println("value of i is " + i + " value of j is " + j)
      }
    }

    // Nested for loop - Scala
    for (i <- 1 to 10; j <- 1 to 10; k <- 1 to 10) {
      println("Value of i is " + i + " value of j is " + j + " value of k is " + k)
    }

    // List - similar to Arrays. List is immutable. i.e. you can not change contents of a List once defined
    println("================For loop for Collections========================")
    var numbersList = List(1,2,3,4,5,6,7,8,9,10)

    for (i <- numbersList) {
      println("value of i is " + i)
    }

    println("========================For loop for Collections with filter==========================")
    var numbersList2 = List(1,2,3,4,5,6,7,8,9,10)
    for (i <- numbersList2 if i % 2 == 0; if i != 4) {
      println("value of i is " + i)
    }

    for (i <- numbersList2) {
      if (i % 2 == 0) {
        println("value of i is for JAVA " + i)
      }
    }

    println("=====================For loop Collections with filter with YIELD====================")
    var numbersList3 = List(1,2,3,4,5,6,7,8,9,10)
    var evenNumberList = for (i <- numbersList3 if i % 2 == 0) yield i
    println(evenNumberList)

    println("=========================For loop for Collections with filter and with break=====================")
    var numbersList4 = List(1,2,3,4,5,6,7,8,9,10)

    val breakObject = new Breaks;

    breakObject.breakable {
      for (i <- numbersList4 if i % 2 == 0) {
        println("value of i is " + i)

        if (i == 4)
          {
            println("i am breaking at 4")
            breakObject.break
          }
      }
    }
  }
}
