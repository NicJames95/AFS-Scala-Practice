class Employee {
  var first: String = ""
  var last: String = ""

  override def toString: String = first + " " + last
}

val bobMartin = new Employee
bobMartin.first = "Bob"
bobMartin.last = "Martin"

bobMartin.toString

val taylorJackson = new Employee
taylorJackson.first = "Taylor"
taylorJackson.last = "Jackson"

bobMartin.first = "Amy"
bobMartin.last = "Jones"

bobMartin
taylorJackson
