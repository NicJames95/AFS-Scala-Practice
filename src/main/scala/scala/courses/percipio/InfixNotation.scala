package scala.courses.percipio

object InfixNotation extends App {

  val s = "Skillsoft"

  s.indexOf('f')
  s indexOf 'f' // infix notation

  class Vehicle (vehicleName: String) {
    var name: String = vehicleName // class field set equal to constructor field
    var avgSpeed: Int = 0

    def calcAvgSpeed(distance: Int, time: Int): Unit = {
      avgSpeed = distance / time
      println("The " + name + " had an average speed of " + avgSpeed + " mph.")
    }
  }

  Honda // this will call and run the Honda object which contains the honda.calcAvgSpeed(200, 2)

  object Honda {
      val honda = new Vehicle("Honda CRV")
      honda calcAvgSpeed (200, 2) // infix notation

  }

}
