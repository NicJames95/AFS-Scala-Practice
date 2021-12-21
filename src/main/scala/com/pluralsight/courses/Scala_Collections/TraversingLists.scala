package com.pluralsight.courses.Scala_Collections

object TraversingLists extends App {

  val numbers = List(2, 4, 6, 7, 8, 1)
  numbers.foreach(print(_))

  val iter = numbers.iterator
  while (iter.hasNext) print(iter.next())

  /** Generator Based For Loops
   * FOR (element <- generator)
   * ANY ITERATOR CAN BE USED
   * SCALA USES THE FOREACH METHOD
   * ALL COLLECTIONS HAVE THE FOREACH METHOD*/
  for (element <- numbers)
    print(element)

  var sum = 0
  var numberss = List(2, 4, 5, 3, 2)
  numberss.foreach(sum += _)
  println(sum)

}
