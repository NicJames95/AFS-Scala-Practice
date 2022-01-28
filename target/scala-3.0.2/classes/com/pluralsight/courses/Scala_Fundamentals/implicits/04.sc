import scala.language.postfixOps
case class Dollars(amount: Int){
  def prettify: String = "$" + amount
}

val customerBalance: Int = 10000

customerBalance prettify