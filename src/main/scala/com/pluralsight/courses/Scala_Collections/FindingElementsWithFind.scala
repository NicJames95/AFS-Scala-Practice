package com.pluralsight.courses.Scala_Collections

object FindingElementsWithFind extends App {

  /** Higher Order Function
   * Any function that takes a function as an argument (or returns a function) */
  val names = List("Sam", "Sarah", "Shirley", "Sidney")
  val sarah: String => Boolean = name => if (name == "Sarah") true else false
  println(names.find(sarah))
  println(names.find(_ == "Sarah"))
  println(names.filter(sarah))

}
