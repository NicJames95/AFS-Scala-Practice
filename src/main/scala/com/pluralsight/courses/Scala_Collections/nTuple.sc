(1, 3)
("A", "B", "C")

/** Tuple
 * ASSIGN, PASS AROUND AND RETURN
 * Tuple2, Tuple3, Tuple4, ...., Tuple22
 * MIX TYPE ELEMENTS
 * SIMPLE DATA STRUCTURES
 * */

/** Type    vs.     Tuple
  Behavior        Simple Semantics
  Context
 */

("BEL", 7)
("CR", 13)
("LF", 10)

val pitcher = "P" -> 1
val catcher = "C" -> 2
val firstBasemen = "1B" -> 3
val secondBasemen = "2B" -> 4
val thirdBasemen = "3B" -> 5
val shortStop = "SS" -> 6
val leftFielder = "LF" -> 7
val centerFielder = "CF" -> 8
val rightFielder = "RF" -> 9

def example(tuple: Any): String = {
  tuple match {
    case (_, _, _) => "3 elements"
    case ("A", _) => "A matched"
    case (_, n: Int) if n > 10 => s"$n is > 10"
    case (a, b) => s"($a, $b)"
  }
}

println("match was " + example(("a", 23)))

