val number = 10

def range(x: Int): Range =
  val x = number
  if (number > 10) 11 until 100 else 1 until 9
  range(107)

val symbol1: String = if (number > 10) {
  "> 10"
} else if (number == 10) {
  "== 10"
} else {
  "<= 10"
}
