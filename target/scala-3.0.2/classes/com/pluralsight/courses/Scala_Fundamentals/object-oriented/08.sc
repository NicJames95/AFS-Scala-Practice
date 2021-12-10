object Employee {
  private val departmentCodeByName: Map[String, String] = Map(
    "HR" -> "Human Resources",
    "ACT" -> "Accounts",
    "R&D" -> "Research and Development",
    "MKT" -> "Marketing",
    "SLS" -> "Sales",
    "OPS" -> "Operations"
  )

  def apply(first: String, last: String, stocks: Int): Employee =
    new Employee(first, last, stocks)

  def getDepartmentName(code: String): String =
    departmentCodeByName.getOrElse(code, "The department with such code does not exist")
}

class Employee(f: String, l: String, s: Int) {
  private val first: String = f
  private val last: String = l
  private var stocks: Int = s

  def getFirst = first
  def getLast = last
  def getStocks = stocks

  def awardMoreStocks(numberOfStocks: Int): Unit = stocks += numberOfStocks

  override def toString: String = s"$first $last $stocks"
}

val bobMartin = Employee("Bob", "Martin", 10)
bobMartin.getLast
Employee.getDepartmentName("R&D")
// can directly call method without instantiating an object

// No longer need to use new keyword because of companion object
// use CO to create new instances and apply method does the job for us