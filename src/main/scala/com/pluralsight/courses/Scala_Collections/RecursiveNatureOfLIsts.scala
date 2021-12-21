package com.pluralsight.courses.Scala_Collections
/** Existing references are never changed by the operations applied to them */
/**
trait List[+A]{
  def head: A
  def tail: List[A]
  def :: [B >: A](element: B): List[B] = Cons(element, this)
}

case object Nil extends List[Nothing]{
  override def head: Nothing = ???
  override def tail: List[Nothing] = ???
}

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def mkString[A](list: List[A]): String = {
    if (list == Nil) ""
    else list.head.toString + " " + mkString(list.tail)
  }
}

object Example extends App {
  val list1 = Cons("a", Cons("b", Cons("c", Cons("d", Nil))))
  val list2 = Nil.::("d")
  val list3 = "a" :: "b" :: "c" :: "d" :: Nil
  println(List.mkString(list2))
}
*/
