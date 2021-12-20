package com.pluralsight.courses.Scala_Classes_And_Objects

import java.time.LocalDateTime

///// "IS A" RELATIONSHIP *********** SOME TYPE ***********
sealed trait Kind
case object Debit extends Kind
case object Credit extends Kind
case object Refund extends Kind
//////////////////////////////////
case class Transaction(name: String, amount: Double, kind: Kind, when: LocalDateTime) // "HAS A" RELATIONSHIP *** PRODUCT TYPE ***

object TransactionRunner extends App {
  private val when = LocalDateTime.now
  val t1 = Transaction("T1", 12.22, Debit, when) // case class built in apply method
  println(t1.toString) // case class toString method already overrided
  //t1.amount = 100.12 // case classes fields come as vals
  val t2 = Transaction("T1", 12.22, Debit, when)
  println(t1 == t2) // case class don't have to write out .equals method
  println(t1.hashCode()) // case class hashCode out of the box

  val t3 = t1.copy(name = "T3", amount = 100.23) // since the fields are immutable, case class provides copy method
  println(t3)
  // Case classes support pattern matching
  val amount = t3 match {
    case Transaction(name, amount, kind, when) => amount  // case classes have unapply method
    case Transaction(_, amount, kind, _) if kind == Debit && amount > 20 => amount - 20
    case t: Transaction => t.amount // default catch all scenario
  }
  println(amount)

  def getMessage(kind: Kind): String = kind match {
    case Debit => "Debit Transaction"
    case Credit => "Credit Transaction"
    case Refund => "Refund Transaction"
  }
  println(getMessage(t1.kind))
}



//trait User {
//  def getFirst: String
//  def getLast: String
//}
//
//trait Transaction {
//  this: User =>  // used to circumvent inheriting from User trait
//  def printAmountWithTransaction(amount: Double): Unit = {
//    val fullCustomerName = this.getFirst + " " + this.getLast
//    val tax = amount * 0.10 // 10%
//    println(s"$fullCustomerName paid $tax on amount of $amount")
//  }
//}
//// class parameters declared with val keyword will generate getters
//// they are also instance variables instead of class parameters
//class DebitTransaction(val first: String, val last: String) extends User with Transaction {
//  override def getFirst: String = first
//  override def getLast: String = last
//}
//
//object TransactionRunner extends App {
//  val transaction = new DebitTransaction("Tony", "Stark")
//  transaction.printAmountWithTransaction(999)
//}
