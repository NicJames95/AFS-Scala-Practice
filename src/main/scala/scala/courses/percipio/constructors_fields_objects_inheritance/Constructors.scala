package scala.courses.percipio.constructors_fields_objects_inheritance

object Constructors extends App {

  class Ball(d: Double, t: String) {
    require(t != "")
    def this(d: Double) = this(d, "default") // auxilary constructor
    println("New " + t + " ball created with diameter " + d + " cm")
  }
  val tennis = new Ball(6.5, "tennis")
  

}
