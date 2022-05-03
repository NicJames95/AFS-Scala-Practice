package com.udemy.scala.programming_in_depth.constructorDemo
// Parameterized constructor (primary constructor)
class demoClass1(val a: Int, val b: Double, val c: String){
  val x = a
  val y = b
  val z = c

  def add() = x + y

  println(s"x = ${x} and y = ${y} and z = ${z}")
}

object ConstructorDemo1 {
  def main(args: Array[String]): Unit = {
    val demoObject1 = new demoClass1(5, 7.2, "Hello World!") // Object: Instance of class -> Calls Constructor

    val result = demoObject1.add()
    println(s"result = ${result}")
  }
}
