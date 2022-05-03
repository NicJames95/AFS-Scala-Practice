package com.udemy.scala.programming_in_depth.traitsDemo

// Value class: Can not allocate runtime object
// Value class always has ONLY 1 PARAMETER WITH TYPE VAL
// You CAN NOT EXTEND a Value class
// VALUE CLASS CAN NOT EXTEND A TRAIT ; USE UNIVERSAL TRAIT

// Benefits of Value Class
// 1. Less initialization
// 2. Better performance
// 3. Less memory usage
// Use Case: Performance and Memory Optimization

// UNIVERSAL TRAIT
trait CarE extends Any {
  def print(): Unit = { println(this) }
}

// VALUE CLASS
class MercedesE(val x: Int) extends AnyVal with CarE {
  // var y = 1 ===> Can not define any fields in a value class. Can only define methods
  def hello: Unit = {
    println("hello")
  }
}

object DemoETrait extends App{
  val m1 = new MercedesE(5)
  m1.print()
  m1.hello
}
