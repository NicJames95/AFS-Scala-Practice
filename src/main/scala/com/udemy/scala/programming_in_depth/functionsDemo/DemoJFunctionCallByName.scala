package com.udemy.scala.programming_in_depth.functionsDemo

object DemoJFunctionCallByName extends App{
  def printValue(m: (Int) => Int, x: Int) = {
    println(s"Value is: ${m(x)}")
  }

  def increment(y: Int) = {
    println(s"Value of y is: $y")
    var z = y + 1
    println(s"Value of y after incrementing is: $z")
    z
  }

  def decrement(y: Int) = {
    println(s"Value of y is: $y")
    var z = y - 1
    println(s"Value of y after decrementing is: $y")
    z
  }

  printValue(increment, 2)
  printValue(decrement, 2)
}
