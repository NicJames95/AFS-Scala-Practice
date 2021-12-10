package scala.courses.percipio

object Conditionals extends App {

  val paramList = Array("first", "second", "third")
  val item = if (!paramList.isEmpty) paramList(0) else "default value"
  println(item)
}
