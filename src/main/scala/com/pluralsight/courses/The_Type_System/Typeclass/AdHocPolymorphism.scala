package com.pluralsight.courses.The_Type_System.Typeclass

trait CombinerPoly {
  /** Ad-Hoc Polymorphism */
  def combine(a: Int, b: Int): Int = a + b

  def combine(a: Int, b: Int, c: Int): Int = a + b + c

  def combine(a: String, b: String): String = s"$a$b"

  def combine[T](a: List[T], b: List[T]): List[T] = a ++ b
}

object CombinerPoly extends CombinerPoly

object AdHocPolymorphism extends App{
  import CombinerPoly._

  /** Method Overloading */
  def add(a: Int, b: Int): Int = a + b
  def add(a: Double, b: Double): Double = a + b

  println(s"Calling add for Integer: ${add(1, 22)}")
  println(s"Calling add for Double: ${add(22.5, 1.5)}")

  // def append(a: List[Int], b: List[Int]): List[Int] = a ++ b
  /** Parametric Polymorphism */
  def append[T](a: List[T], b: List[T]): List[T] = a ++ b

  val listFirst = List(1, 2, 3)
  val listSecond = List(4, 5)
  println(s"Calling append for Integer List: ${append(listFirst, listSecond)}")

  println(s"Calling combine for Integer: ${combine(21, 22)}")

  println(s"Calling combine for String: ${combine("foo", "bar")}")

  println(s"Calling combine for Integer List: ${combine(listFirst, listSecond)}")

}


