package scala.courses.percipio

object OperatorsAndOverloading extends App {

  4 + 6 // actually using the "+" method on the 4 object and passing in the parameter 6
  4.+(6) // ^^^^^^ infix notation above
  // Operators are methods in Scala
  // common operators - / * %
  6 % 4
  // relational operators < <= > >=
  6 > 4
  // logical operators && ||
  val t = true
  val f = false
  val test = t || f
  // unary not operator !
  !f
  // bitwise operators & | ^
  1 | 2 // binaray operation 0001 | 0010 = 0011 = 3
  // operator overloading
  val num = 3 + 5L
  5.55D + 2.2F

}
