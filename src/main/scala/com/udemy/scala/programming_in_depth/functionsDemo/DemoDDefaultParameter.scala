package com.udemy.scala.programming_in_depth.functionsDemo

import scala.io.StdIn.readInt

object DemoDDefaultParameter extends App{
  def div(x: Int = 5, y: Int = 1): Double = {
    println(s"Value of x is: $x")
    println(s"Value of y is: $y")
    return (x / y.toDouble)
  }

  println("Enter 2 numbers")
  var a: Int = readInt()
  var b: Int = readInt()
  println(div(a,b))

  println(div(2,3))
  println(div(2))
  println(div(y = 2))
}
