package com.udemy.scala.programming_in_depth.functionsDemo

object DemoERecursiveFunctions extends App{
  def factorial(n: Int): Int = {
    if (n <= 1)
      1
    else
      n * factorial(n - 1)
  }
  var fact = factorial(5)
  println(fact)
}
