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
val amount = 100

currency match {
  case u: USD => println(s"USD $amount")
  case c: CAD => println(s"CAD $amount" * (1/1.30))
  case n: NZD => println(s"NZD $amount" * (1/1.50))
}