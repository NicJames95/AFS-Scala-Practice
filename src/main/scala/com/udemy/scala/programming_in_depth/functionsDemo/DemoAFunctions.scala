package com.udemy.scala.programming_in_depth.functionsDemo

object DemoAFunctions extends App{
  def sum (x: Int, y: Int): Int = {
    var z: Int = x + y
    return z
  }

  var a = sum(2,3)
  println(a)
}
