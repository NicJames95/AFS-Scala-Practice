package practice

object CaseClasses extends App {

  case class Animal(name: String, carnivore: Boolean)

  val animalList = Seq(Animal("dog", true), Animal("cat", true), Animal("rhino", false))

  val cheetah = Animal("cheetah", true)
  val evilfish = cheetah.copy(name = "fish")

  val evilfishList = animalList.map(animal => animal.copy(name = "fish"))
  println(evilfishList)
  println(animalList)

  /*
    adds "tiny" before the input animal
  */
  def makeTiny(animal: String): String = {
    "tiny " + animal
  }
  println(makeTiny("cat"))

  /**
   *
  1. Create a case class for Pizza that includes the following fields:
	a. toppings - List of Strings
	b. sizeInches - integer
	c. cost - integer
	d. discountApplied - Optional Boolean
	e. name - String
  2. Create a method called tellMeAboutThePie that takes a pizza object as input, and returns a String
  3. The method should return the following statement: "This pizza is called [name], and it has the following toppings: [toppings separated by comma]. It costs [cost] dollars, which ["includes" or "does not include"] a discount. It is [sizeInches] inches in diameter."
	  - note: I do not expect this method to be done in one line
  4. Instantiate 2 or 3 different kinds of pizzas, and call tellMeAboutThePie method for each one.
   */

 case class Pizza(toppings: List[String], sizeInches: Int, cost: Int, discountApplied: Option[Boolean], name: String)
  

  def tellMeAboutThePie(pizza: Pizza): String = {
    s"This pizza is called "
  }

  val pepperoni = new Pizza(List("sausage", "pepperoni", "ham", "bacon"), 12, 19, Some(true), "All Meat")


  // 1. suppose you have the case class as follows:
 case class Food(name:String, weightInOunces: Int, pairedWine: Option[String])

  // and the instances of this case class:

  val steak = Food("steak", 8, Some("merlot"))
  val fish = Food("fish", 6, Some("pinot"))
  val bacon = Food("bacon", 4, None)

  //a. Create your own instance of Food, and give None for pairedWine
  val hamburger = Food("hamburger", 6, None)
  //b. Create a list that contains these 4 instances.
  val foodList = List(steak, fish, bacon, hamburger)
  //c. Using the list from (b), return a new list that contains just the weights.
  //	- expected result: Seq(8,6,4)
  val ozList = Seq(steak.weightInOunces, fish.weightInOunces, hamburger.weightInOunces, bacon.weightInOunces)
  //d. Using the list from (b), return a new list that contains just the paired wines that exist
  //	- expected result: Seq("merlot", "pinot")
  val wineList = Seq(steak.pairedWine, fish.pairedWine, hamburger.pairedWine, bacon.pairedWine)
  println(wineList)
  //e. Determine the sum of the weights in the list of food.
  val foodWeight = (foodList.map(meat => meat.weightInOunces)).sum
  //f. Assume you like "cabernet" wine. Make a copy of the steak variable and change the pairedWine to "cabernet".
  val cabernetSteak = steak.copy(pairedWine = Some("cabernet"))
  //g. Using the list from (b), return a new list such that the pairedWine value for EACH Food instance is "cabernet".
  val cabernetList = foodList.map(meat => meat.copy(pairedWine = Some("cabernet")))
  //h. You are hungry. Using the list from (b), return a new list with the weightInOunces increased by 10 for each food.
  val ozListAdd10 = foodList.map(meat => meat.weightInOunces + 10)
  //i. Using the list from (b), filter the list and return only those foods that weigh more than 6 ounces. Output ONLY the "name" value of these foods.
  //	- hint: use filter and then map
  //	- expected result: Seq("steak", ...)
  val filteredMeats = foodList.filter(meat => meat.weightInOunces > 6).map(meat => meat.name)
  println(filteredMeats)
  //j. Using the list from (b), filter only on the foods that contain a pairedWine. Output ONLY the name of these foods.
  val pairedWineList = foodList.filter(meat => meat.pairedWine.contains(Some)).map(meat => meat.name)
  println(pairedWineList)


}
