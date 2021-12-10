package scala.courses.percipio.constructors_fields_objects_inheritance

object Setters extends App {

  class SomeClass {
   private[this] var q = 0
   def quantity: Int = q
//   def quantity_= (b: Int) { q = b }  DOES NOT WORK ? MAYBE OLDER SCALA
   def set_quantity(b: Int): Unit = { q = b }
  }
  val s = new SomeClass
  s.set_quantity(23)

  class Ball{
    private[this] var d: Double = _
    def get_diam = d
    def set_diam (m: Double): Unit = {
      require(3.8 <= m && m < 24.26)
      d = m
    }
  }

  val b = new Ball
  b.set_diam(9.83)
  println(b.get_diam)

  // b.set_diam(50)
  // println(b.get_diam) Illegal Argument



}
