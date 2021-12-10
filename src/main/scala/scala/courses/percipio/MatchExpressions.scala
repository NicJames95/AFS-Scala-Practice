package scala.courses.percipio

object MatchExpressions extends App {

  val paramList = Array("first", "second", "third")
  val item = if (!paramList.isEmpty) paramList(0) else "default value"
  val choice = item match {
    case "first" => "first selected"
    case "second" => "second selected"
    case "third" => "third selected"
    case _ => "default value selected"
  }
  // _ wildcard for implementing unknown values
  println(choice)

}
