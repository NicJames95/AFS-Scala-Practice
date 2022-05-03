package com.udemy.scala.programming_in_depth.functionsDemo
// Anonymous Functions
// Function without a name and def keyword
// First Class Function... Pass Function as parameter and define function values
object DemoFAnonymousFunctions extends App{
  // Anonymous Function with 1 input parameter and 1 ouput parameter
  // Normal Way of defining an increments function
//  def increments(x: Int): Int = {
//    return x + 1
//  }

  // Using function value / Anonymous functions
  var increments = (x: Int) => x + 1
  println(s"Increment Function output is: ${increments(5)}")

  // Example 2: Anonymous Function with 0 input parameter and 0 ouput parameter
  // Normal way of defining function
//  def printHelloWorld() = {
//    println("Hello World!")
//  }
//  printHelloWorld()

  // Using function value / Anonymous functions
  var printHelloWorld = () => println("Hello World!")
  printHelloWorld()

  // Example 3: Anonymous Function with 2 input parameters and 1 output parameter
//  def add (x: Int, y: Int): Int = {
//    x + y
//  }
  // Using function value / Anonymous functions 
  var add = (x: Int, y: Int) => x + y
  println(s"Add function output is: ${add(2,3)}")
}
