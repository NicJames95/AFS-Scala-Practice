package com.udemy.scala.programming_in_depth.conditionalStatementDemo

object DemoBWhileLoop {
  def main(args: Array[String]): Unit = {
    var x = 12

    while (x < 10) {
      println("Value of x is " + x)
      x = x + 1
    }
    
//    do {
//      println("Value of x is " + x)
//      x = x + 1
//    } while (x < 10)
  }
}
