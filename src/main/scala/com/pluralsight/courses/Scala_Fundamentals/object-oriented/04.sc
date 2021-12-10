class Employee(val first: String, val last: String) {
  // can access first and last fields if case class or adding val
  override def toString: String = s"$first $last"
}

val bobMartin = new Employee("Bob", "Martin")
bobMartin.first
bobMartin.last

class Color(val value: String) // public val field
val c = new Color("red")
c.value

class Shape(var value: String) // public var field
val s = new Shape("circle")
s.value
s.value = "square"
s.value