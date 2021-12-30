package com.pluralsight.courses.The_Type_System.TypeBasics

import java.io.File
import scala.io.Source

object TraitDemo extends App {

  trait FileOps {
    self: File =>

    def isTextFile: Boolean = this.getName.endsWith("txt")

    def readText: Iterator[String] =
      if (this.isTextFile)
        Source.fromFile(this).getLines()
      else
        Iterator.empty

    def printLines: Unit =
      this.readText foreach println
  }

  val fooTextFile = new File("./src/m2/foo.txt") with FileOps

  println(fooTextFile.getName)
  println(fooTextFile.isTextFile)

  sealed trait TaskStatus
  case object Pending extends TaskStatus
  case object InProgress extends TaskStatus
  case object Completed extends TaskStatus

  def returnsTaskStatus: TaskStatus = {
    returnsTaskStatus match {
      case Pending => ???
      case InProgress => ???
      case Completed => ???
    }
  }

}
