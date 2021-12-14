package com.pluralsight.courses.Scala_Fundamentals.project.entities

object Dollars {
  // ADDED ZERO DURING TRAITS
  val Zero = new Dollars(0)
  def apply(a: Int): Dollars = new Dollars(a)
}

class Dollars(val amount: Int) extends AnyVal with Ordered[Dollars] {
  override def compare(that: Dollars): Int = amount - that.amount

  def +(dollars: Dollars): Dollars = new Dollars(amount + dollars.amount)

  def -(dollars: Dollars): Dollars = new Dollars(amount - dollars.amount)

  override def toString: String = "$" + amount
}

//class Dollars(val amount: Int) extends AnyVal {
//  def +(value: Int): Dollars = new Dollars(amount + value)
//
//  def -(value: Int): Dollars = new Dollars(amount - value)
//
//  def >(value: Int): Boolean = amount > value
//
//  override def toString: String = "$" + amount
//}

//class Dollars(val amount: Int) extends AnyVal {
//  def +(dollars: Dollars): Dollars = new Dollars(amount + dollars.amount)
//
//  def -(dollars: Dollars): Dollars = new Dollars(amount - dollars.amount)
//
//  def >(dollars: Dollars): Boolean = amount > dollars.amount
//
//  override def toString: String = "$" + amount
//}
