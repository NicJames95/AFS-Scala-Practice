package com.udemy.scala.programming_in_depth.functionsDemo

object DemoGAnonymousFunctions extends App{
  var listOfNumbers = List(0,1,2,3,4,5,6,7,8,9)
  listOfNumbers foreach(num => if (divisibleByThree(num)) {
    println(s"$num is divisible by three")
  }
  else {
    println(s"$num is not divisible by three")
  })

  // Traditional Way
  def divisibleByThree(x: Int) = {
    x % 3 == 0
  }

  // Anonymous function
//  var divisibleByThree = (x: Int) => x % 3 == 0

  // Use Filter
  var divisibleByThreeOutput = listOfNumbers.filter(_ % 3 == 0)
  divisibleByThreeOutput foreach(x => print(x))
}
