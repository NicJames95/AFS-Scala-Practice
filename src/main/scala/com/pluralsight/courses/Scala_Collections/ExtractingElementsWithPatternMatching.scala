package com.pluralsight.courses.Scala_Collections

object ExtractingElementsWithPatternMatching extends App {
  /** Extractor Patterns
   *  uses unapplySeq
   * */
  val names = List("Dale", "Susan", "Bob", "Del")
  names match {
    case List("Dale", _, _) => println("found Dale") // only matches on lists of size 3
    case List(_, "Susan", x, _*) if x == "Bob" => println("after Susan is " + x)  // sequence wildcard _* allows any size list
    // so long as "Susan" is 2nd element
    case _ => println("no match")
  }

  case class Person(first: String, age: Int)

  /** Constructor Patterns
   * Allow you to match against the arguments that were used to construct an object(case class)
   * uses unapply
   * apply(a, b) --> object(a, b)
   * unapply(object(a, b)) --> a, b
   * */
  val person = Person("Dale", 21)
  person match {
    case Person("Dale", _) => println("found Dale")
    case Person(_, 21) => println("found 21")
    case Person("Bob", 21) => println("found Bob, 21")
  }

  val listOfNames = List(List("Dale", "Susan"), List("Bob", "Del"))
  listOfNames match {
    case List(List("Dale", _, _), _*) => println("found Dale")
    case List(List(_, "Susan", x, _*), _*) => println("after Susan is " + x)
    case List(_, List("Bob", _*), _*) => println("found Bob")
  }

}
