package com.udemy.scala.programming_in_depth.functionsDemo

object DemoSCurryingFunctions extends App{
  val str1 = "Hello"
  val str2 = "World"

  println(s"str1, str2 ${printSomething(str1)(str2)}")
  

  def printSomething(str1: String)(str2: String): String = {
    str1 + " " + str2
  }

  
}
