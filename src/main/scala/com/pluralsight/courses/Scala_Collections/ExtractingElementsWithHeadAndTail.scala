package com.pluralsight.courses.Scala_Collections

object ExtractingElementsWithHeadAndTail extends App {
  /** 1. Decompose the head
   *  2. Recurse on the tail
   *  3. The base case */
  def sum(list: List[Int]): Int = {
    if (list.isEmpty) 0
    else list.head + sum(list.tail)
  }

  def find[A](target: A, list: List[A]): Option[A] = {
    if (list.isEmpty) None
    else if (list.head == target) Some(list.head)
    else find(target, list.tail)
  }


}
