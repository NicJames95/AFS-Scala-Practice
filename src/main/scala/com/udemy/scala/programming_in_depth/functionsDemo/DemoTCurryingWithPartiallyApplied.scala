package com.udemy.scala.programming_in_depth.functionsDemo

object DemoTCurryingWithPartiallyApplied extends App{
  def add2(a: Int)(b: Int) = a + b

  val sum = add2(29)_
  println(sum(5))

  // Function Chaining
  // = Function currying
  // partially applied function(i.e. use _)
}
