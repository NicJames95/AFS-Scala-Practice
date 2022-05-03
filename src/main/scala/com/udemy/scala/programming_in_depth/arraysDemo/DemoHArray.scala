package com.udemy.scala.programming_in_depth.arraysDemo

import scala.collection.mutable.ArrayBuffer

object DemoHArray extends App{
  val marks = ArrayBuffer[Int]()
  marks += 10
  marks += 6
  marks += 3

  println("Marks so far")
  marks foreach println

  marks += 5
  println("Marks so far")
  marks foreach println

  marks append 7
  marks ++= Array(5,9,7,3,5,8,9,1,2,5,7)
  println("Marks so far")
  marks foreach println

  marks -= 5
  println("Marks so far")
  marks foreach println
}
