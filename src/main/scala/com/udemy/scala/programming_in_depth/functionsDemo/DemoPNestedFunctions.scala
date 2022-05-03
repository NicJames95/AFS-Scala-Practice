package com.udemy.scala.programming_in_depth.functionsDemo

object DemoPNestedFunctions {
  def main(args: Array[String]): Unit = {
    def printHello(msg: String) = {
      println(s"Hello $msg")
    }

    val printHello2 = (msg: String) => println(s"Hello $msg")

    printHello("World")
    printHello2("India")
  }
}
