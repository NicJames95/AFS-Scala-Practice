package practice

object Doc3_MethodsAndCaseMatching extends App {

  /*
  Section 1: Methods
  1. Create a case class for Pizza that includes the following fields:
    a. toppings - List of Strings
    b. sizeInches - integer
    c. cost - integer
    d. discountApplied - Optional Boolean
    e. name - String
  2. Create a method called tellMeAboutThePie that takes a pizza object as input, and returns a String
  3. The method should return the following statement: "This pizza is called [name], and it has the
  following toppings: [toppings separated by comma]. It costs [cost] dollars, which ["includes" or "does
  not include"] a discount. It is [sizeInches] inches in diameter."
    -note: I do not expect this method to be done in one line
  4. Instantiate 2 or 3 different kinds of pizzas, and call tellMeAboutThePie method for each one.
  Section 2: Pattern Matching
  Given this sample:
  val myObject: String = "123"
  myObject match {
  case s: String => "it's a string"
  case i: Int => "it's an integer"
  case _ => "it's something else" // default case
  } // returns "it's a string"
  1. change myObject to an integer and see what happens
  2. change myObject to a Boolean and see what happens
  3. instantiate a new Pizza object and define it as an optional value
    -i.e. val myPizza: Option[Pizza] = Pizza(...)
  4. Using pattern matching, perform the following:
    a. if myPizza contains a value, return the string "the optional value exists, and the name of the
    pizza is [pizza's name]"
    b. if myPizza does not contain a value (is None), return the string "The optional value is empty"
  5. change myPizza to be None and see what happens
  6. Create a new match/case and match on the specific value of sizeInches:
    -if the size of the pizza is 10, return the string "The pizza is 10 inches, which is a single portion"
    -if the size is any other number, return the string "The pizza is some other size"
  7. ** (challenge) Create a new match/case and do the following:
    - if myPizza contains a value and discountApplied is True, return "The pizza exists and there is a
    discount"
    - if myPizza contains a value but discountApplied is False, return "The pizza exists but there is no
    discount"
    - in all other cases, return "The pizza doesn't exist
  ************
  Section 1: Methods
  Question 1
  Create a case class for Pizza that includes the following fields:
    a. toppings - List of Strings
    b. sizeInches - integer
    c. cost - integer
    d. discountApplied - Optional Boolean
    e. name - String
  */
  case class Pizza(toppings: List[String], sizeInches: Int, cost: Int, discountApplied: Boolean, name: String)
  {
    /*
    Question 2
    Create a method called tellMeAboutThePie that takes a pizza object as input, and returns a String
    Question 3
    The method should return the following statement: "This pizza is called [name], and it has the following
    toppings: [toppings separated by comma]. It costs [cost] dollars, which ["includes" or "does not include"]
    a discount. It is [sizeInches] inches in diameter."
      -note: I do not expect this method to be done in one line
    */
    def tellMeAboutThePie(pizza: Pizza): String = {
      val discount = if (discountApplied == true) "includes"
      else "does not include"
      s"This pizza is called $name, and it has the following toppings: ${toppings.mkString(", ")}. It costs $cost dollars, which $discount a discount. It is $sizeInches inches in diameter"
    } // .mkString turns the list into a string

    def pizzaSizeMatch(pizza: Pizza): String = pizza match {
      case size10 if (pizza.sizeInches == 10) => "The pizza is 10 inches, which is a single portion"
      case _ => "The pizza is some other size"
    }
  }
  /*
  Question 4
  Instantiate 2 or 3 different kinds of pizzas, and call tellMeAboutThePie method for each one
  */
  val allMeat = new Pizza(List("sausage", "pepperoni", "ham", "bacon"), 12, 18, true, "All Meat")
  val deluxe = new Pizza(List("sausage", "mushroom", "onion", "green pepper", "bacon"), 14, 24, false, "Deluxe")
  val veggie = new Pizza(List("mushroom", "green pepper", "onion", "black olive", "tomato"), 14, 20,true, "Veggie")
  val garden = new Pizza(List("creamy garlic italian sauce", "mushroom", "red peppers", "broccoli", "spinach"), 16,28,true, "Creamy Garlic Garden")
  val sb = new Pizza(List("sausage", "bacon"), 10, 9, false, "Sausage Bacon")
  println(allMeat.tellMeAboutThePie(allMeat))
  println(deluxe.tellMeAboutThePie(deluxe))
  println(veggie.tellMeAboutThePie(veggie))
  println(garden.tellMeAboutThePie(garden))
  println(sb.tellMeAboutThePie(sb))
  /*
  Section 2: Pattern Matching
  val myObject: String = "123"
  myObject match {
    case s: String => "it's a string"
    case i: Int => "it's an integer"
    case _ => "it's something else" // default case
  } // returns "it's a string"

  Question 1
  change myObject to an integer and see what happens
  Question 2
  change myObject to a Boolean and see what happens
  */
// WILL NOT COMPILE IN ALL INSTANCES
//  val myObject: Boolean = false
//  myObject match {
//    case s: String => "it's a string"
//    case i: Int => "it's an integer"
//    case _ => "it's something else"
//  }
  /*
  Question 3
  instantiate a new Pizza object and define it as an optional value
    - i.e. val myPizza: Option[Pizza] = Pizza(...)
  */
  val myPizza: Option[Pizza] = Some(new Pizza(List("meat sauce", "toasted ravioli, mozzarella sticks"), 10, 10, true, "Nic's pizza"))
  //val myPizza: Option[Pizza] = None
  println(myPizza)
  /*
  Question 4
  Using pattern matching, perform the following:
    a. if myPizza contains a value, return the string "the optional value exists, and the name of the
    pizza is [pizza's name]"
    b. if myPizza does not contain a value (is None), return the string "The optional value is empty"
  */
  val myPizzaMatch = myPizza match {
    case Some(pizza: Pizza) => s"the optional value exists, and the name of the pizza is " + pizza.name + ""
    case None => "The optional value is empty"
    case _ => "something else"
  }
  /*
  Question 5
  change myPizza to be None and see what happens
    val myPizza: Option[Pizza] = None
  */
  println(myPizzaMatch)
  /*
  Question 6
  Create a new match/case and match on the specific value of sizeInches:
    - if the size of the pizza is 10, return the string "The pizza is 10 inches, which is a single portion"
    - if the size is any other number, return the string "The pizza is some other size"

    def pizzaSizeMatch(pizza: Pizza): String = pizza match {
    case size10 if (pizza.sizeInches == 10) => "The pizza is 10 inches, which is a single portion"
    case _ => "The pizza is some other size"
  }
  */
  println(allMeat.pizzaSizeMatch(allMeat))
  println(sb.pizzaSizeMatch(sb))
  /*
  Question 7 **** - needs to be finished
  (challenge) Create a new match/case and do the following:
    - if myPizza contains a value and discountApplied is True, return "The pizza exists and there is a
  discount"
    - if myPizza contains a value but discountApplied is False, return "The pizza exists but there is no
  discount"
    - in all other cases, return "The pizza doesn't exist"
  */

}
