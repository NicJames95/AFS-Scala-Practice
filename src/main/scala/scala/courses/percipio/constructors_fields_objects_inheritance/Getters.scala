package scala.courses.percipio.constructors_fields_objects_inheritance

object Getters extends App {

  class SomeClass{
    private[this] var q = 0
    def quantity: Int = q // getter
    // def quantity_= (b: Int){ q = b } // setter // compilation error (GforG example)
    // getters and setters can't be named the same as well as named the same as variable we are getting
    // this is because scala doesn't allow fields and methods to have the same name
    // quantity_= is the default setter created if q were a public variable 
  }

  val s = new SomeClass
  println(s.quantity)

  class Ball {
    private[this] var d: Double = _
    def diamInches = d / 2.54 // conversion equation for cm to inches
     //def diam_= (m: Double): Unit = { d = m } // compilation error see(GforG example)
  }

  val b = new Ball
  //b.diam_= 24 // compilation error

  // Geeks for Geeks Example

  class Student
  {
    var student_name: String = " "
    var student_age: Int = _
    private var student_rollno = 0

    def set_rollno(x: Int): Unit = {
      student_rollno = x
    }
    def get_rollno(): Int = {
      return student_rollno
    }
  }

  var obj = new Student()
  obj.student_name = "Yash"
  obj.student_age = 22
  obj.set_rollno(59)

  println(s"Student name: ${obj.student_name}")
  println(s"Student age: ${obj.student_age}")
  println(s"Student Rollno: ${obj.get_rollno()}")







}
