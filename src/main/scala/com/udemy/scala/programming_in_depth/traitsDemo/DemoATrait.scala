package com.udemy.scala.programming_in_depth.traitsDemo

trait Car {
  def engine(): Unit = {
    println("Engine is 1000 CC")
  }

  def brake(): Unit

  def tires(): Unit
}

class Mercedes extends Car {
  def brake(): Unit = {
    println("Disk Brakes")
  }

  def tires(): Unit = {
    println("4 Tires")
  }
}

object DemoATrait extends App{
  val m1 = new Mercedes
  m1.brake()
  m1.tires()
  m1.engine()
}
