package com.udemy.scala.programming_in_depth.constructorDemo

class demoClass{
  val x = 3
  val y = 2

  def add(x: Int, y: Int) = x + y

  println(s"x = ${x} and y = ${y}")
}

object ConstructorDemo {
  def main(args: Array[String]): Unit = {
    val demoObject1 = new demoClass
    // Creating a object = instance of class = Constructor will execute every thing in the class
    demoObject1.add(4, 8)
  }
}
