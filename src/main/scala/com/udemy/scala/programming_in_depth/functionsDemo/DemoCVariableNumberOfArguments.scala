package com.udemy.scala.programming_in_depth.functionsDemo
// Variable number of Arguments in a Function
object DemoCVariableNumberOfArguments extends App{
  def printMultipleTimes(n: Int, args: String*) = { // String* means defining Array[String]
    for (arg <- args) { // for each element in args ("Hello", "World", "India", "Singapore"),
      println(arg * n)  // arg Hello, execute the for loop
                        // arg World, execute the for loop ... India ... Singapore
    }
  }

  printMultipleTimes(3, "Hello", "World", "India", "Singapore")
}
