package com.pluralsight.courses.Scala_Collections

import java.util
import scala.collection.mutable
import scala.jdk.CollectionConverters.*

object CollectionConverters extends App {

  val elementsJava = new util.ArrayList[Int]()
  val elementsScala: mutable.Seq[Int] = elementsJava.asScala

  for (element <- elementsScala) {
    println(element)
  }

  val moreJava: util.List[Int] = elementsScala.asJava

}
