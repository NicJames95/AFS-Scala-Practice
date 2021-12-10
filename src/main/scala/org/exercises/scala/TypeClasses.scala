package org.exercises.scala

import scala.math.Ordering

object TypeClasses extends App {

  /*
  Remember the sorting function:

  def insertionSort(xs: List[Int]): List[Int] = {
    def insert(y: Int, ys: List[Int]): List[Int] =
      ys match {
        case List() => y :: List()
        case z :: zs =>
          if (y < z) y :: z :: zs
          else z :: insert(y, zs)
      }
    xs match {
      case List() => List()
      case y :: ys => insert(y, insertionSort(ys))
    }
  }

  How to parameterize insertionSort so that it can also be used for lists with elements other than Int
  (like, for instance, Rational)?

  def insertionSort[T](xs: List[T]): List[T] = ...
  The above attempt does not work, because the comparison < in insert is not defined for arbitrary types T.

  Idea: parameterize insert with the necessary comparison function.

  PARAMETERIZATION OF SORT
  The most flexible design is to make the function insertionSort polymorphic and to pass the
  comparison operation as an additional parameter:
   */
  def insertionSort[T](xs: List[T])(lessThan: (T, T) => Boolean): List[T] = {
    def insert(y: T, ys: List[T]): List[T] =
      ys match {
        case List() => y :: List()
        case z :: zs =>
          if (lessThan(y, z)) y :: z :: zs
          else z :: insert(y, zs)
      }

    xs match {
      case List() => List()
      case y :: ys => insert(y, insertionSort(ys)(lessThan))
    }
  }

  /*
  CALLING PARAMETERIZED SORT
  We can now call insertionSort as follows:
  */
  val nums = List(-5, 6, 3, 2, 7)
  val fruit = List("apple", "pear", "orange", "pineapple")
  insertionSort(nums)((x: Int, y: Int) => x < y)
  insertionSort(fruit)((x: String, y: String) => x.compareTo(y) < 0)

  /*
  Or, since parameter types can be inferred from the call insertionSort(xs):

  insertionSort(nums)((x, y) => x < y)

  PARAMETRIZATION WITH ORDERED
  There is already a class in the standard library that represents orderings.
      scala.math.Ordering[T]
  provides ways to compare elements of type T. So instead of parameterizing with the lessThan operation directly,
   we could parameterize with Ordering instead:
  */
  def orderedInsertionSort[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    def insert(y: T, ys: List[T]): List[T] =
      ys match {
        case List() => y :: List()
        case z :: zs =>
          if (ord.lt(y, z)) y :: z :: zs
          else z :: insert(y, zs)
      }

    xs match {
      case List() => List()
      case y :: ys => insert(y, orderedInsertionSort(ys)(ord))
    }
  }
  /*
  ORDERED INSTANCES:
  Calling the new insertionSort can be done like this:
  */
  orderedInsertionSort(nums)(Ordering.Int)
  orderedInsertionSort(fruit)(Ordering.String)

  /*
  This makes use of the values Int and String defined in the scala.math.Ordering object, which produce the right orderings on integers and strings.

  IMPLICIT PARAMETERS
  Problem: Passing around lessThan or ord values is cumbersome.

  We can avoid this by making ord an implicit parameter:
  */
  def implicitInsertionSort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    def insert(y: T, ys: List[T]): List[T] =
      ys match {
        case List() => y :: List()
        case z :: zs =>
          if (ord.lt(y, z)) y :: z :: zs
          else z :: insert(y, zs)
      }

    xs match {
      case List() => List()
      case y :: ys => insert(y, implicitInsertionSort(ys))
    }
  }
  // Then calls to insertionSort can avoid the ordering parameters:
  implicitInsertionSort(nums)
  implicitInsertionSort(fruit)

  /*
  he compiler will figure out the right implicit to pass based on the demanded type.

  RULES FOR IMPLICIT PARAMETERS
  Say, a function takes an implicit parameter of type T.

  The compiler will search an implicit definition that

    is marked implicit
    has a type compatible with T
    is visible at the point of the function call, or is defined in a companion object associated with T.
  If there is a single (most specific) definition, it will be taken as actual argument for the implicit parameter. Otherwise it's an error.

  TYPE CLASSES
  The combination of types parameterized and implicit parameters is also called type classes.

  EXERCISES
  Define an ordering for the Rational type:
  */
  class Rational(x: Int, y: Int) {
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private val g = gcd(x, y)

    lazy val numer: Int = x / g
    lazy val denom: Int = y / g
  }

  val compareRationals: (Rational, Rational) => Int = (x: Rational, y: Rational) =>
    if (x.numer == y.numer) (x.denom - y.denom) else (x.numer - y.numer)

  implicit val rationalOrder: Ordering[Rational] = new Ordering[Rational] {
    def compare(x: Rational, y: Rational): Int = compareRationals(x, y)
  }

  val half = new Rational(1, 2)
  val third = new Rational(1, 3)
  val fourth = new Rational(1, 4)
  val rationals = List(third, half, fourth)
  implicitInsertionSort(rationals) // shouldBe List(fourth, third, half)
}
