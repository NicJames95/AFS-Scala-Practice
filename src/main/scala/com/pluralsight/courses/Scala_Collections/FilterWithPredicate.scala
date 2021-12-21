package com.pluralsight.courses.Scala_Collections

object FilterWithPredicate extends App {
  /** Predicate
   * Any function that returns a boolean, typically used to define a condition.
   * Useful when used with higher oreder functions
   * */
  val evens: Int => Boolean = _ % 2 == 0
  val shortWords: String => Boolean = _.length <= 3
  /** def filter(p: A => Boolean): List[A] */
  val numbers = List(1, 2, 3, 4, 5, 6)
  val words = "The quick brown fox jumps over the lazy dog".split(" ").to(List)
  println(numbers.filter(evens))
  println(words.filter(shortWords))
  /** filterNot takeWhile
   *  withFilter  dropWhile
   *  partition   span
   *  find*/
}
