package com.udemy.scala.programming_in_depth.functionsDemo
// Functions with Named Arguments
object DemoBFunctionWithNamedArguments extends App {
  def sum(x: Int, y: Int): Int = {
    println(s"Value of x is: $x")
    println(s"Value of y is: $y")
    return (x + y)
  }

  var z = sum(y = 2, x = 3)
  println(z)
}
