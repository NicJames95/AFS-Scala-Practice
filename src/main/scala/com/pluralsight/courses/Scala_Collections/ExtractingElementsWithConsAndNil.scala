package com.pluralsight.courses.Scala_Collections

import scala.annotation.tailrec

object ExtractingElementsWithConsAndNil {

  /** 1. Deconstruct the head
   *  2. Recurse on the tail
   *  3. Set the base case */
  def sum(list: List[Int]): Int = {
    list match {
//      case list if list.isEmpty => 0
//      case ::(head, tail) => head + sum(tail)
      case Nil => 0
      case head :: tail => head + sum(tail)
    }
  }

  @tailrec
  def tailSum(list: List[Int], accumulator: Int): Int = {
    list match {
      case Nil => 0
      case head :: tail => tailSum(tail, head + accumulator)
    }
  }

  @tailrec
  def find[A](target: A, list: List[A]): Option[A] = {
    list match {
      case Nil => None
      case head :: _ if head == target => Some(head)
      case _ :: tail => find(target, tail)
    }
  }

  "hello dave".split(" ").toList match {
    case "hello" :: name :: Nil => println("greeting " + name)
    case "bye" :: name :: Nil => println("say goodbye" + name)
    case "goodbye" :: name :: Nil => println("say goodbye" + name)
    case _ :: name :: Nil => println("no greeting for " + name)
    case _ => println("invalid command")
  }

}
