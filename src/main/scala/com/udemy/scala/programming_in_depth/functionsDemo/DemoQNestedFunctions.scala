package com.udemy.scala.programming_in_depth.functionsDemo

object DemoQNestedFunctions extends App{
  val printHello = (str: String) => {

    def printSomething(str1: String, str2: String): Unit = {
      println(str1 + " " + str2)
    }
    printSomething(s"Hello", str)
  }

  printHello("World")
  printHello("India")
}
