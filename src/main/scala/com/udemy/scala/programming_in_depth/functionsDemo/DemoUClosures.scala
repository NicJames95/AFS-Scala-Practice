package com.udemy.scala.programming_in_depth.functionsDemo
// Closures: Variables are defined outside function definition
object DemoUClosures extends App{
  def multiplier (x: Int) = {
    x * 10
  }

  println(multiplier2(5))

  val factor = 9

  val multiplier2 = (x: Int) => x * factor
  // if variable (eg: factor) is defined outside the function body, it is called a Closure

  // if variable is used inside function body (eg factor) is neither an input parameter
  // nor defined inside function body

  val multiplier3 = (x: Int) => {
    var factor1 = 1
    x * factor1
  }
}
