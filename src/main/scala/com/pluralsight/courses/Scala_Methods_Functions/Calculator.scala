package com.pluralsight.courses.Scala_Methods_Functions

object Calculator extends App {

  def computeSum(a: Int, b: Int): Int = {
    return a + b // return is optional
    a + b
  }
  /** A method defined using just curly braces and no "=" sign is a PROCEDURE,
   * a procedure does not return anything, its result type is always Unit */
  def printSum(a: Int, b: Int): Unit = {
    println("Sum of a and b is: " + (a + b))
  }

  val result = Calculator.computeSum(5, 6)
  println("Result is: " + result)
  printSum(11, 12)

}
