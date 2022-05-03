package com.udemy.scala.programming_in_depth.functionsDemo

object DemoHAnonymousFunctions extends App{
  var listOfNumbers: List[Int] = List(0,1,2,3,4,5,6,7,8,9)
  // use with Map
  var squareOfNumbers = listOfNumbers.map(square(_))
  println(squareOfNumbers)

  // var squareOfNumbersAAA = listOfNumbers.map((x: Int) => x * x)
  var squareOfNumbersAAA = listOfNumbers.map(x => x * x)
  // var squareOfNumbersAAA = listOfNumbers.map(_ * _) NOTE: WILL NOT WORK, EXPECTS TWO INPUTS
  // HOWEVER map ONLY PROVIDES 1 INPUT. i.e. map PROVIDES ONE NUMBER AT A TIME
  println(squareOfNumbersAAA)

  // var doubleOfNumbers = listOfNumbers.map((x: Int) => (x * 2))
  // var doubleOfNumbers = listOfNumbers.map(x => x * 2)
  var doubleOfNumbers = listOfNumbers.map(_ * 2)
  println(doubleOfNumbers)

//  def square(x: Int) = {
//    x * x
//  }

  // Function value
  val square:Int => Int = (x: Int) => x * x

  val a:Int = 3
}
