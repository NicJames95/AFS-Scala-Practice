package scala.courses.percipio

object JavaTypesInScala extends App {

  val s = "Some text"
  val f = 5

  def test(a: Int, b: Int) = a == b
  println(test(100, 100))

  def newTes(a: Any, b: Any) = a == b // if done in java using java.lang.Object as params: false
  println(newTes(100, 100))



}
