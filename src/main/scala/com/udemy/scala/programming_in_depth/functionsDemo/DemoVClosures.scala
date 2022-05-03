package com.udemy.scala.programming_in_depth.functionsDemo

object DemoVClosures extends App{
  // def isEven (x: Int): Boolean = { // Traditional Function Definition
  //  x % 2 == 0
  // }

  def evenOrOdd(x: Int): String = {
    val evenFlag = isEven(x)
    if (evenFlag)
      "Even Number"
    else
      "Odd Number"
  }

  val isEvenOrOdd = (f: Int => Boolean, x: Int) => {
    val evenFlag = f(x)
    if (evenFlag)
      "Even Number"
    else
      "Odd Number"
  }

  val div = 2
  val isEven = (x: Int) => x % div == 0
  // val isEven: (Int) => Boolean = (x) => { x % 2 == 0 } // If you want to specify return type

  println(isEven(2))
  println(isEven(3))
  println(isEven(4))
  println(isEven(5))
  println(isEven(6))

  println(evenOrOdd(2))
  println(evenOrOdd(3))
  println(evenOrOdd(4))
  println(evenOrOdd(5))
  println(evenOrOdd(6))

  println(isEvenOrOdd(isEven, 2))
  println(isEvenOrOdd(isEven, 3))
  println(isEvenOrOdd(isEven, 4))
  println(isEvenOrOdd(isEven, 5))
  println(isEvenOrOdd(isEven, 6))
}
