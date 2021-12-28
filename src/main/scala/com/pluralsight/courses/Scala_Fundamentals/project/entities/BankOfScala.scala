package com.pluralsight.courses.Scala_Fundamentals.project.entities

import java.time.LocalDate
import java.util.UUID
import scala.util.Random

object BankOfScala {
  /* Phase 5 Refactor based on collections module */
  val random = new scala.util.Random()

  def main(args: Array[String]): Unit = {

    println("Opening Bank")

    val bank = new Bank(name = "Bank of Scala", country = "New Zealand", city = "Auckland", email = Email("bank", "scala.com"))
    val customerIds = getCustomers map { c => bank.createNewCustomer(c._1, c._2, c._3, c._4) }
    val depositProductIds = getDepositProducts map { p => bank.addNewDepositProduct(p._1, p._2, p._3) }
    val lendingProductIds = getLendingProducts map { l => bank.addNewLendingProduct(l._2, l._3, l._4) }

    /* logging */
    println(s"Bank: $bank")
    println(s"CustomerIds: $customerIds")
    println(s"Deposits Product Ids: $depositProductIds")
    println(s"LendingProductIds: $lendingProductIds")

    /* Updated this method */
    def openAccounts(customerId: UUID,product: Product): Dollars => UUID = product.category match {
      case DepositsP => bank.openDepositAccount(customerId, product.id, _: Dollars)
      case LendingP => bank.openLendingAccount(customerId, product.id, _: Dollars)
    }

    /*
    Bank Clerk opening the account.
    There is no money deposited in the account yet, so the accounts are not active
    */
    val depositAccounts = for (c <- customerIds; p <- depositProductIds) yield openAccounts(c, bank.getDepositProduct(p).get)

    /* Depositing money into the account */
    val depositAccountIds = depositAccounts map { account => account(Dollars(10000 + random.nextInt(10000))) }

    /* logging */
    println(s"Deposits Accounts: $depositAccounts")
    println(s"Deposits Account Ids: $depositAccountIds")

    /*
      Open credit card accounts.
      The bank process has not finished the credit check, so, balance will be known later
    */
    val lendingAccounts = for (c <- customerIds; p <- lendingProductIds) yield openAccounts(c, bank.getLendingProduct(p).get)
    val lendingAccountIds = lendingAccounts.map { account => account(Dollars(random.nextInt(500))) }

    /* logging */
    println(s"Lending Accounts: $lendingAccounts")
    println(s"Lending Account Ids: $lendingAccountIds")
    println(s"Bank: $bank")

    /*
      Performing Deposit Accounts transactions
    */
    depositAccountIds foreach { accountId =>
      bank deposit(accountId, Dollars(1 + random.nextInt(100)))
      bank withdraw(accountId, Dollars(1 + random.nextInt(50)))
    }
    // ^^^^^^^ Reformatted Above
    // depositAccountIds.foreach(bank deposit(_, Dollars(1 + randomAmount.nextInt(100))))
    //    depositAccountIds.foreach(bank withdraw(_, Dollars(1 + randomAmount.nextInt(50))))

    /*
     Performing Lending Accounts transactions
   */
    lendingAccountIds foreach { accountId =>
      bank useCreditCard(accountId, Dollars(1 + random.nextInt(500)))
      bank payCreditCardBill(accountId, Dollars(1 + random.nextInt(100)))
    }
    //^^^^^^^^ Reformatted above
    //    lendingAccountIds.foreach(bank useCreditCard (_, Dollars(1 + randomAmount.nextInt(500))))
    //    lendingAccountIds.foreach(bank payCreditCardBill (_, Dollars(1 + randomAmount.nextInt(100))))

    /** Request Currency */
    println("-" * 100)
    println("Requesting Currency")
    bank.requestCurrency(depositAccountIds.head, "120 USD")
    bank.requestCurrency(depositAccountIds.tail.head, "100 CAD")

    /** Statistics */
    println("-" * 100)
    println("Statistics")
    println("-" * 100)

    val dAccounts = depositAccountIds flatMap { bank.getDepositAccount }
    println(s"Total Money Deposited to Bank: ${bank.getTotalMoneyDeposited(dAccounts)}")

    val lAccounts = lendingAccountIds flatMap { bank.getLendingAccount }
    println(s"Total Money Borrowed by Customers: ${bank.getTotalMoneyBorrowedByCustomers(lAccounts)}")

    val allAccounts = dAccounts ++ lAccounts
    println(s"Number of Transactions By Account: ${bank.getNumTransactionsByAccount(allAccounts)}")
  }

  /* --------------------------------- Data ----------------------------- */
  def getCustomers: Seq[(String, String, String, String)] = {
    Seq(
      ("Bob", "Martin", "bob@martin.com", "1976/11/25"),
      ("Amy", "Jones", "amy.jones@google.com", "1983/4/12"),
      ("Taylor", "Jackson", "taylor33@jackson.com", "1985/4/5"),
      ("Rob", "Johnson", "rob@johnson.com", "1976/3/6"),
      ("Maggie", "Harting", "maggie23@apple.com", "1979/12/3"),
      ("Deb", "Das", "debdas@ge.com", "1981/4/12"),
      ("Chris", "Baron", "chris@ibm.com", "1977/2/12"),
      ("Julie", "James", "julie@james.com", "1983/1/22"),
      ("Oscar", "Chin", "oscar@mama.com", "1982/4/12"),
      ("Sophie", "Smith", "sophie@fb.com", "1990/12/1")
    )
  }

  def getDepositProducts: Seq[(String, Int, Double)] = {
    Seq(
      ("CoreChecking", 1000, 0.025),
      ("StudentCheckings", 0, 0.010),
      ("RewardsSavings", 10000, 0.10)
    )
  }

  def getLendingProducts: Seq[(String, Double, Double, Double)] = {
    Seq(("CreditCard", 99.00, 14.23, 20.00))
  }
}
/* Phase 3
Phase 4 added curly braces and openAccounts function  */
//  def main(args: Array[String]): Unit = {
//
//    println("Opening Bank")
//
//    val bank = new Bank(name = "Bank of Scala", country = "New Zealand", city = "Auckland", email = Email("bank", "scala.com"))
//    val customerIds = getCustomers map { c => bank.createNewCustomer(c._1, c._2, c._3, c._4) }
//    val depositProductIds = getDepositProducts map { p => bank.addNewDepositProduct(p._1, p._2, p._3) }
//    val lendingProductIds = getLendingProducts map { l => bank.addNewLendingProduct(l._2, l._3, l._4) }
//
//    /* logging */
//    println(s"Bank: $bank")
//    println(s"CustomerIds: $customerIds")
//    println(s"Deposits Product Ids: $depositProductIds")
//    println(s"LendingProductIds: $lendingProductIds")
//
//    /* Added this method */
//    def openAccounts(customerId: UUID, productId: UUID, productType: String): Dollars => UUID = productType match {
//      case "Deposits" => bank.openDepositAccount(customerId, productId, _: Dollars)
//      case "Lending" => bank.openLendingAccount(customerId, productId, _: Dollars)
//    }
//
//    /*
//    Bank Clerk opening the account.
//    There is no money deposited in the account yet, so the accounts are not active
//    */
//    val depositAccounts = for (c <- customerIds; p <- depositProductIds) yield openAccounts(c, p, "Deposits")
//
//    /* Depositing money into the account */
//    val random = new scala.util.Random()
//    val depositAccountIds = depositAccounts.map { account => account(Dollars(10000 + random.nextInt(10000))) }
//
//    /* logging */
//    println(s"Deposits Accounts: $depositAccounts")
//    println(s"Deposits Account Ids: $depositAccountIds")
//
//    /*
//      Open credit card accounts.
//      The bank process has not finished the credit check, so, balance will be known later
//    */
//    val lendingAccounts = for (c <- customerIds; p <- lendingProductIds) yield openAccounts(c, p, "Lending")
//    val lendingAccountIds = lendingAccounts.map { account => account(Dollars(random.nextInt(500))) }
//
//    /* logging */
//    println(s"Lending Accounts: $lendingAccounts")
//    println(s"Lending Account Ids: $lendingAccountIds")
//    println(s"Bank: $bank")
//
//    /*
//      Performing Deposit Accounts transactions
//    */
//    val randomAmount = new scala.util.Random(100)
//    depositAccountIds foreach { accountId =>
//      bank deposit(accountId, Dollars(1 + randomAmount.nextInt(100)))
//      bank withdraw(accountId, Dollars(1 + randomAmount.nextInt(50)))
//    }
//    // ^^^^^^^ Reformatted Above
//    // depositAccountIds.foreach(bank deposit(_, Dollars(1 + randomAmount.nextInt(100))))
//    //    depositAccountIds.foreach(bank withdraw(_, Dollars(1 + randomAmount.nextInt(50))))
//
//    /*
//     Performing Lending Accounts transactions
//   */
//    lendingAccountIds foreach { accountId =>
//      bank useCreditCard(accountId, Dollars(1 + randomAmount.nextInt(500)))
//      bank payCreditCardBill(accountId, Dollars(1 + randomAmount.nextInt(100)))
//    }
//^^^^^^^^ Reformatted above
//    lendingAccountIds.foreach(bank useCreditCard (_, Dollars(1 + randomAmount.nextInt(500))))
//    lendingAccountIds.foreach(bank payCreditCardBill (_, Dollars(1 + randomAmount.nextInt(100))))
// }

//  /* --------------------------------- Data ----------------------------- */
//  def getCustomers: Seq[(String, String, String, String)] = {
//    Seq(
//      ("Bob", "Martin", "bob@martin.com", "1976/11/25"),
//      ("Amy", "Jones", "amy.jones@google.com", "1983/4/12"),
//      ("Taylor", "Jackson", "taylor33@jackson.com", "1985/4/5")
//    )
//  }
//
//  def getDepositProducts: Seq[(String, Int, Double)] = {
//    Seq(
//      ("CoreChecking", 1000, 0.025),
//      ("StudentCheckings", 0, 0.010),
//      ("RewardsSavings", 10000, 0.10)
//    )
//  }
//
//  def getLendingProducts: Seq[(String, Double, Double, Double)] = {
//    Seq(("CreditCard", 99.00, 14.23, 20.00))
//  }


/* Phase 2 */
//    println("Instantiating Bank")
//
//    val coreChecking = new CoreChecking(Dollars(1000), 0.025)
//    val studentCheckings = new StudentCheckings(Dollars(0), 0.010)
//    val rewardsSavings = new RewardsSavings(Dollars(10000), 0.10, 1)
//    val creditCard = new CreditCard(99.00, 14.23, 20.00)
//    val products = Set(coreChecking, studentCheckings, rewardsSavings, creditCard)
//
//    val bobMartin = new Customer("Bob", "Martin",Email("bob", "martin.com"),
//      LocalDate.of(1983, 8, 22))
//    val bobCheckingAccount = new DepositsAccount(bobMartin, coreChecking, Dollars(1000))
//    val bobSavingsAccount = new DepositsAccount(bobMartin, rewardsSavings, Dollars(20000))
//    val bobCreditAccount = new LendingAccount(bobMartin, creditCard, Dollars(4500))
//    val accounts = Set(bobCheckingAccount, bobSavingsAccount, bobCreditAccount)
//
//    val bank = new Bank("Bank Of Scala", "Auckland", "New Zealand",Email("bank", "scala.com"), products, Set(bobMartin), accounts)
//
//    println(bobCheckingAccount)
//
//    bobCheckingAccount.deposit(dollars = 100)
//    println(bobCheckingAccount)
//
//    bobCheckingAccount.withdraw(dollars = 200)
//    println(bobCheckingAccount)

/* Phase 1 */

//    val coreChecking = new CoreChecking(1000, 0.025)
//    val studentCheckings = new StudentCheckings(0, 0.010)
//    val rewardsSavings = new RewardsSavings(10000, 0.10, 1)
//    val creditCard = new CreditCard(99.00, 14.23, 20.00)
//    val products = Set(coreChecking, studentCheckings, rewardsSavings, creditCard)
//
//    val bobMartin = new Customer("Bob", "Martin", "bob@martin.com",
//      LocalDate.of(1983, 8, 22))
//    val bobCheckingAccount = new Account(bobMartin, coreChecking, 1000)
//    val bobSavingsAccount = new Account(bobMartin, rewardsSavings, 20000)
//    val bobCreditAccount = new Account(bobMartin, creditCard, 4500)
//    val accounts = Set(bobCheckingAccount, bobSavingsAccount, bobCreditAccount)
//
//    val bank = new Bank("Bank Of Scala", "Auckland", "New Zealand", "bank@scala.com", products, Set(bobMartin), accounts)
//
//    println(bobCheckingAccount)
//
//    bobCheckingAccount.deposit(100)
//    println(bobCheckingAccount)
//
//    bobCheckingAccount.withdraw(200)
//    println(bobCheckingAccount)
// }

