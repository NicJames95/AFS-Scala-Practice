def square(x: Int): Int = x * x
val sq_2 = square(2)

def multiply(x: Int, y: Int) = x * y
val mul_10_30 = multiply(10, 30)

def multiply(nums: Int*): Int = {
  var product = 1
  for(num <- nums) product = product * num
  product
}
val mul_10_20_30 = multiply(nums = 10, 20, 30)
val mul_x_y = multiply(10, 20)
val mul_multiple = multiply(10, 20, 30, 40, 50)

def sumOdd(n: Int): Int = {
  // local function
  def getOdd(x: Int): Array[Int] = {
    var result = Array[Int]()
    var current = 1
    while (current <= x) {
      if (current % 2 == 1) result = result :+ current
      current = current + 1
    }
    result
  }
  val odds = getOdd(n)
  println(odds.mkString(","))
  odds.sum
}
sumOdd(20)

def greet(first: String, last: String): Unit = {
  println("Hello! " + first + ", " + last)
}
greet("Tony", "Stark")
greet("Stark", "Tony")
greet(last = "Stark", first = "Tony")

def logTransaction(amount: Double, debit: Boolean = true , currency: String = "USD"): Unit = {
  val symbol = if (debit) "-" else "+"
  println(symbol + currency + amount)
}

logTransaction(amount = 100.25)
logTransaction(amount = 23.15)
logTransaction(amount = 89.33)
logTransaction(amount = 89.33, debit = false, currency = "NZD")
logTransaction(currency = "CAD", debit = false, amount = 4300.98)

import com.pluralsight.courses.Currency
import com.pluralsight.courses.Implicits.stringToCurrency
val cad: Currency = "CAD 100"