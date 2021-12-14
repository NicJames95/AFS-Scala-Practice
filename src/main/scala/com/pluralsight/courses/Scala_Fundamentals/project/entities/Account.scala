package com.pluralsight.courses.Scala_Fundamentals.project.entities
import com.pluralsight.courses.Scala_Fundamentals.project.entities.Dollars.Zero

import java.util.UUID



/* ------------------------- VERSION 3 ------------------------------ */
sealed trait TransactionType
case object In extends TransactionType
case object Out extends TransactionType

case class Transaction(customer: Customer, amount: Dollars,
                       transactionType: TransactionType, accountCategory: AccountCategory)

sealed trait AccountCategory
case object DepositsA extends AccountCategory
case object LendingA extends AccountCategory

abstract class Account {
  val id: UUID = UUID.randomUUID()
  val customer: Customer
  val product: Product
  val category: AccountCategory
  var transactions: Seq[Transaction] = Seq.empty

  def getBalance: Dollars
}

class DepositsAccount(val customer: Customer,
                      val product: Deposits,
                      private var balance: Dollars) extends Account {
  override val category: AccountCategory = DepositsA
  // changed all ints to dollars
  def deposit(dollars: Dollars): Unit = {
    require(dollars > Zero, "amount deposited should be greater than zero.")
    balance += dollars
    transactions = transactions :+ Transaction(customer, dollars, In, category)
    println(s"Deposited $dollars to ${this.toString}")
  }

  def withdraw(dollars: Dollars): Unit = {
    require(dollars > Zero && balance > dollars,
      "amount should be greater than zero and requested amount should be less than or equal to balance.")
    balance -= dollars
    transactions = transactions :+ Transaction(customer, dollars, Out, category)
    println(s"Withdrawn $dollars to ${this.toString}")
  }

  override def getBalance: Dollars = balance
  override def toString = s"$customer with $product has remaining balance of $balance"
}

class LendingAccount(val customer: Customer,
                     val product: Lending,
                     private var balance: Dollars) extends Account {
  override val category: AccountCategory = LendingA

  def payBill(dollars: Dollars): Unit = {
    require(dollars > Zero, "The payment must be made for amount greater than zero.")
    balance += dollars
    transactions = transactions :+ Transaction(customer, dollars, In, category)
    println(s"Paid bill of $dollars against ${this.toString}")
  }

  def withdraw(dollars: Dollars): Unit = {
    require(dollars > Zero, "The withdrawal amount must be greater than zero.")
    balance -= dollars
    transactions = transactions :+ Transaction(customer, dollars, Out, category)
    println(s"Debited $dollars from ${this.toString}")
  }

  override def getBalance: Dollars = balance
  override def toString = s"$customer with $product has remaining balance of $balance"
}
/* ------------ Version 1 --------------- */
//class Account(c: Customer, p: Product, b: Int){
//  val customer: Customer = c
//  val product: Product = p
//  private var balance: Int = b
//
//  def deposit(amount: Int): Unit = {
//    println(s"Depositing $amount to $customer account")
//    balance += amount
//  }
//
//  def withdraw(amount: Int): Unit = {
//    println(s"Withdrawing $amount to $customer account")
//    balance -= amount
//  }
//
//  override def toString = s"$customer with $product has remaining balance of $balance"
//}

/* ------------------ Version 2 -------------- */

//abstract class Account {
//  val id: UUID = UUID.randomUUID()
//  val customer: Customer
//  val product: Product
//  def getBalance: Dollars
//
//}
//
//class DepositsAccount(val customer: Customer,
//                      val product: Deposits,
//                      private var balance: Dollars) extends Account {
//// changed all ints to dollars
//  def deposit(dollars: Dollars): Unit = {
//    require(dollars > Dollars(0), "amount deposited should be greater than zero.")
//    println(s"Deposited $dollars to ${this.toString}")
//    balance += dollars
//  }
//
//  def withdraw(dollars: Dollars): Unit = {
//    require(dollars > Dollars(0) && balance > dollars,
//      "amount should be greater than zero and requested amount should be less than or equal to balance.")
//    println(s"Withdrawn $dollars to ${this.toString}")
//    balance -= dollars
//  }
//
//  override def getBalance: Dollars = balance
//  override def toString = s"$customer with $product has remaining balance of $balance"
//}
//
//class LendingAccount(val customer: Customer,
//                     val product: Lending,
//                     private var balance: Dollars) extends Account {
//
//  def payBill(dollars: Dollars): Unit = {
//    require(dollars > Dollars(0), "The payment must be made for amount greater than zero.")
//    println(s"Paid bill of $dollars against ${this.toString}")
//    balance += dollars
//  }
//
//  def withdraw(dollars: Dollars): Unit = {
//    require(dollars > Dollars(0), "The withdrawal amount must be greater than zero.")
//    println(s"Debited $dollars from ${this.toString}")
//    balance -= dollars
//  }
//
//  override def getBalance: Dollars = balance
//  override def toString = s"$customer with $product has remaining balance of $balance"
//}


