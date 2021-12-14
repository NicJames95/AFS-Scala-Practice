package com.pluralsight.courses.Scala_Fundamentals.project.entities

import java.util.UUID
/* ADDED PRODUCT CATEGORY WITH COLLECTIONS */
sealed trait ProductCategory
case object DepositsP extends ProductCategory
case object LendingP extends ProductCategory

abstract class Product {
  val id: UUID = UUID.randomUUID()
  val category: ProductCategory
  val name: String

  override def toString: String = "product " + name
}

/* ----------------------------Deposits Products --------------------------------- */
abstract class Deposits extends Product {
  override val category = DepositsP
  val interestRatePerYear: Double
  val minimumBalancePerMonth: Dollars
}

abstract class Checkings extends Deposits

abstract class Savings extends Deposits {
  val transactionsAllowedPerMonth: Int
}

/* --------------- Checkings Products ------------------ */
class CoreChecking(val minimumBalancePerMonth: Dollars, val interestRatePerYear: Double) extends Checkings {
  println("Created Core Checking Product")
  //  override val interestRatePerYear: Double = rate
  //  override val minimumBalancePerMonth: Int = bal
  override val name: String = "Core Checking"
}

class StudentCheckings(val minimumBalancePerMonth: Dollars, val interestRatePerYear: Double) extends Checkings {
  println("Created Student Checking Product")
//  override val interestRatePerYear: Double = rate
//  override val minimumBalancePerMonth: Int = bal
  override val name: String = "Student Checking"
}

/* ------------- Savings Products ---------- */
class RewardsSavings(val minimumBalancePerMonth: Dollars, val interestRatePerYear: Double, trans: Int) extends Savings {
  println("Created Rewards Savings Product")
//  override val interestRatePerYear: Double = rate
//  override val minimumBalancePerMonth: Int = bal
  override val transactionsAllowedPerMonth: Int = trans
  override val name: String = "Rewards Savings"
}

/* ---------------------------- Lendings Products ------------------------- */
abstract class Lending extends Product {
  override val category = LendingP
  val annualFee: Double
  val apr: Double
  val rewardsPercent: Double
}

class CreditCard(fee: Double, rate: Double, pct: Double) extends Lending {
  println("Created Credit Card Product")
  override val annualFee: Double = fee
  override val apr: Double = rate
  override val rewardsPercent: Double = pct
  override val name: String = "Credit Card"
}
