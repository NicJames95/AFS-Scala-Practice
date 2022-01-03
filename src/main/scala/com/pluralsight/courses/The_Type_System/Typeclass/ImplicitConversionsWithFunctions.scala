package com.pluralsight.courses.The_Type_System.Typeclass

import java.io.File
import scala.io.Source

object ImplicitConversionsWithFunctions extends App{

  type TextLine = String

  def parse(text: Iterator[TextLine]): List[String] = {
    text.map { line =>
      line
        .split(" ")
        .filter(_.length >= 1)
        .map(_.toLowerCase)
        .toList
    }.toList.flatten
  }

  val file = new File("./src/module6/foo.txt")

  //val linesOfString: Iterator[String] = Source.fromFile(file).getLines()

  implicit def stringToTextLine(str: String): Iterator[TextLine] = Iterator(str)

  val lineOfString: String = "This is a line of String"

  parse(lineOfString) foreach println

}
