package com.udemy.scala.programming_in_depth.functionsDemo

object DemoKFunctionCallByNameCalculator extends App{
  def calculator(m: (Int, Int) => Int, x: Int, y: Int): Int = {
    println(s"Value is: ${m(x, y)}")
    m(x,y)
  }

  val add = (x: Int, y: Int) => x + y
  val sub = (x: Int, y: Int) => x - y
  val mul = (x: Int, y: Int) => x * y
  val div = (x: Int, y: Int) => x / y
  val rem = (x: Int, y: Int) => x % y

  calculator(add, 1, 2)
  calculator(sub, 2, 2)
  calculator(mul, 3, 2)
  calculator(div, 4, 2)
  calculator(rem, 5, 2)
}
