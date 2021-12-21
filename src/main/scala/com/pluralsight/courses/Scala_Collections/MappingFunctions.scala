package com.pluralsight.courses.Scala_Collections

import scala.collection.mutable
import java.util.Calendar._
import java.util.Calendar.{getInstance => calendar}

object MappingFunctions extends App {

  val double: Int => Int = _ * 2
  val numbers = List(1, 4, 2, 5, 6, 8)
  val doubled = numbers.map(double)
  println(doubled)

  def age(year: Int): Int = {
    calendar.get(YEAR) - year
  }

  val years = List(1990, 1984)
   println(years.map(age))

  def ages(year: Int): List[Int] = {
    List(age(year-1), age(year+1))
  }

  println(years.map(ages))
  println(years.flatMap(ages))
}
/** Map                                                         FlatMap
 * applies one-to-ONE transformation                            applies one-to-MANY transformation
 * A => B                                                       A => List[B]
 * List[B]                                                      List[B]
 * def map(f: A => B): List[B]                                  def map(f: A => List[B]): List[B]
 * */
class Mappable[A](elements: List[A]) {
  def map[B](f: A => B): List[B] = {
    val list = mutable.ListBuffer[B]()
    elements.foreach(list += f(_))
    list.toList
  }
}

