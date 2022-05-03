package com.udemy.scala.programming_in_depth.traitsDemo

trait FourWheelerB {
  def tires(): Unit = {
    println("4 Tires: Four Wheeler")
  }
}

trait CarB {
  def engine(): Unit = {
    println("Engine is 1000 CC")
  }

  def tires(): Unit = println("4 Tires: Car")

  def brake(): Unit
}

class MercedesB extends FourWheelerB with CarB {
  def brake(): Unit = {
    println("Disk Brakes")
  }
  override def tires(): Unit = super.tires()
}

object DemoBTrait extends App{
  val m1 = new MercedesB
  m1.brake()
  m1.tires()
  m1.engine()
}
