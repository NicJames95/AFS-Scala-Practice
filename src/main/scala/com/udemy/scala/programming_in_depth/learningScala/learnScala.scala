package com.udemy.scala.programming_in_depth.learningScala

object learnScala {

  def main(args: Array[String]): Unit = {
    var result = addMethod(2, 5)
    println(s"Addition of 2 and 5 = $result")
  }

  def addMethod(x: Int, y: Int): Int = {
    var z = x + y
    return z
  }

  val addFunction = (x: Int, y: Int) => {
    var z = x + y
    z
  }
}
