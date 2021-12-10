val amounts = Array(10, 24, 35, 23, 12)
val currencies = Array("USD", "NZD")

var sum = 0
for (amount <- amounts) {
  sum = sum + amount
}
println(sum)

for (amount <- amounts) {
  println(amount)
}

val result: Array[Int] = for (amount <- amounts) yield amount

val currAmount: Array[String] = for {
  amount <- amounts
  currency <- currencies
  if amount > 20 && currency.contains("NZD")
} yield currency + " $" + amount

// foreach is a statement
amounts.flatMap(a => currencies.map(currency => s"$currency$a"))
amounts.foreach(amount => println("$"+amount * 10000))

List(1, 2, 3, 4).foreach(num => println(num * 20))