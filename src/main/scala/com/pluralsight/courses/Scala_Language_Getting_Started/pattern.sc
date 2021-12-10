var amount = 55

val result = amount match {
  case 50 => println("$50")
  case 100 => println("$100")
  case a if a == 50 => println("bill is >= 50, it's " + a)
  case a if a == 100 => println("bill is == 100, it's " + a)
  case a => println(s"The amount is: $a")
}

abstract class Currency
case class USD() extends Currency
case class CAD() extends Currency
case class NZD() extends Currency

val currency: Currency = NZD()
val exchange = 100.00

//currency match {
//  case u: USD => println(s"USD $exchange")
//  case c: CAD => println(s"CAD $exchange" * (1/1.30))
//  case n: NZD => println(s"NZD $exchange" * (1/1.50))
//}

val anArray = Array(100, 200, 300)

anArray match {
  case Array(_, second, _) => println("second=" + second)
}

val aTuple = ("USD", 100)
println(aTuple._1)

aTuple match {
  case (currency, amount) if currency == "USD" => println("USD " + amount)
  case (currency, amount) if currency == "NZD" => println("NZD " + amount * (1/1.50))
}