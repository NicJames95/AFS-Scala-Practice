package com.pluralsight.courses.Scala_Classes_And_Objects.classesAndmethods

import java.util.UUID

class Customer(first: String, last: String, email: String) {
  private val _id: UUID = UUID.randomUUID()
  private val _first: String = first
  private val _last: String = last
  private val _email: String = email

  def getId: UUID = _id
  def getFirst: String = _first
  def getLast: String = _last
  def getEmail: String = _email

  override def toString: String = s"$_first, $_last, $_email"
}
// with final on base class cannont extend the class
// class HackCustomer(first: String = "****", last: String = "****", email: String = "****") extends Customer(first, last, email)

trait Address {
  protected var _zip: Int
  protected var _street: String
  protected var _state: String

  def setZip(zip: Int): Unit
  def setStreet(street: String): Unit
  def setState(state: String): Unit
}

trait SecretCodeGenerator {
  def getOTP: String = UUID.randomUUID().toString
}

class CustomerWithAddress(first: String, last: String, email: String) extends Customer(first, last, email)
  with Address with SecretCodeGenerator {
  protected var _zip: Int = -1
  protected var _street: String = ""
  protected var _state: String = ""

  override def setZip(zip: Int): Unit = _zip = zip
  override def setStreet(street: String): Unit = _street = street
  override def setState(state: String): Unit = _state = state
  def printAddress(): Unit = println(s"${_street}, ${_state}, ${_zip}")
}

class DepositBoxContainer extends SecretCodeGenerator

object EmailRunner extends App {
//  val c1: Customer = new Customer("Tony", "Stark", "tony@stark.com")
//  println(c1.getId)
//  println(c1.getFirst)
//  println(c1.getLast)
//  println(c1.getEmail)

//  val hackC1: HackCustomer = new HackCustomer()
//  println(hackC1.getId)
//  println(hackC1.getFirst)
//  println(hackC1.getLast)
//  println(hackC1.getEmail)

val tony = new CustomerWithAddress("Tony", "Stark", "t@stark.com")
tony.setZip(05050)
tony.setStreet("45 Fremont St")
tony.setState("CA")
println(tony)
tony.printAddress()
println(tony.getOTP)

val depositBoxContainer = new DepositBoxContainer
println("DepositBoxContainer OTP: " + depositBoxContainer.getOTP)
}
