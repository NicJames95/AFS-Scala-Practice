package com.udemy.scala.programming_in_depth.traitsDemo

abstract class Vehicle {
  def category(): Unit
}

trait FourWheelerC {
  def tires(): Unit = {
    println("4 Tires: Four Wheeler")
  }
}

trait CarC {
  var x = 1000
  val t = 4
  def engine(): Unit = {
    println(s"Engine is $x CC: Car")
  }

  def tires(): Unit = {
    println(s"$t Tires: Car")
  }

  def brake(): Unit
}

class MercedesC extends Vehicle with FourWheelerC with CarC {
  x = 2000
  override val t = 6

  def brake(): Unit = {
    println("Disk Brakes: Mercedes")
  }

  override def tires(): Unit = super.tires()

  def category(): Unit = {
    println("Mercedes")
  }

  override def engine(): Unit = {
    println(s"Engine is $x CC: Mercedes")
  }
}

object DemoCTrait extends App{
  val m1 = new MercedesC
  m1.tires()
  m1.brake()
  m1.engine()
  m1.category()
}
