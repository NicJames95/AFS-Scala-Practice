package scala.courses.percipio

object Collections extends App{

  // Lazy collections don't consume memory until they are accessed
  // Mutable or Immutable
  val d = List(5, 6, 7, 8)
  val f = Set(3, 6, 9, 12)
  f(3)
  f(16)
  val g = Map("a" -> 1, "b" -> 2, "c" -> 3)
  g("c")
  val t = ("Car", 5) // tuple
  val k: Option[String] = Some("Y")


}
