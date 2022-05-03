package com.udemy.scala.programming_in_depth.functionsDemo

object DemoIFunctionCallByName extends App{
  def printValue(m: => Int) = {
    println(s"Value is: $m")
  }

  def increment() = {
    var y = 2
    println(s"Value of y is: $y")
    var z = y + 1
    println(s"Value of y after incrementing is: $z")
    z
  }

  def decrement() = {
    var y = 2
    println(s"Value of y is: $y")
    var z = y - 1
    println(s"Value of y after decrementing is: $z")
    z
  }

  printValue(increment())
  printValue(decrement())
}
