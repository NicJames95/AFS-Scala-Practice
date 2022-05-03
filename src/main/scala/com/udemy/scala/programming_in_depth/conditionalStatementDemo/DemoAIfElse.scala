package com.udemy.scala.programming_in_depth.conditionalStatementDemo

object DemoAIfElse {
  def main(args: Array[String]): Unit = {
    val x = 2

    if (x > 5) println(s"$x is greater than 5") else println(s"$x is less than or equal to 5")

    if (x == 1) {
      println(s"$x is equal to 1")
    } else if (x == 2) {
      println(s"$x is equal to 2")
    } else if (x == 3) {
      println(s"$x is equalt to 3")
    } else {
      println(s"$x is greater than 3")
    }
  }
}
