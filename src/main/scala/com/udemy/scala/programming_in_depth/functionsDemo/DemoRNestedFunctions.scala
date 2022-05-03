package com.udemy.scala.programming_in_depth.functionsDemo

object DemoRNestedFunctions extends App{
  def factorial(i: Int): Int = {

    def fact(x: Int, prevResult: Int): Int = {
      if (x <= 1)
        prevResult
      else
        fact(x - 1, x * prevResult)
    }
    var z = fact(i, 1)
    return z
  }

  println(factorial(5))
  println(factorial(3))
  println(factorial(0))
}
