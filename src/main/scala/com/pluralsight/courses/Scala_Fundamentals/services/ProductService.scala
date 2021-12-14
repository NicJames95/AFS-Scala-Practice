package com.pluralsight.courses.Scala_Fundamentals.services

import com.pluralsight.courses.Scala_Fundamentals.project.entities.{CoreChecking, CreditCard, Dollars, RewardsSavings, StudentCheckings}

import java.util.UUID

trait ProductService extends ProductsDb {
  /**
   * // todo: (challenge?) how to disallow products of same name?
   *
   * @param name                         : name of the product
   * @param minBalance                   : the minimum balance required for the product
   * @param ratePerYear                  : the rate of interest earned by the end of the year
   * @param transacationsAllowedPerMonth : number of free transactions allowed for the product (optional)
   * @return the product id for the new product
   * */
  def addNewDepositProduct(name: String, minBalance: Int, ratePerYear: Double,
                           transactionsAllowedPerMonth: Int = 2): UUID = {
    val product = name match {
      case "CoreChecking" => new CoreChecking(Dollars(minBalance), ratePerYear)
      case "StudentCheckings" => new StudentCheckings(Dollars(minBalance), ratePerYear)
      case "RewardsSavings" => new RewardsSavings(Dollars(minBalance), ratePerYear, transactionsAllowedPerMonth)
    }
    // depositProducts += (product.id -> product) MOVED TO Db
    saveDepositProduct(product)
    product.id
  }

  def addNewLendingProduct(annualFee: Double, apr: Double, rewardsPercent: Double): UUID = {
    val product = new CreditCard(annualFee, apr, rewardsPercent)
    // lendingProducts += (product.id -> product) MOVED TO Db
    saveLendingProduct(product)
    product.id
  }

}
