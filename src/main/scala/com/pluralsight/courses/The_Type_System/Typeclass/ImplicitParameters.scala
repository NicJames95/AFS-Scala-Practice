package com.pluralsight.courses.The_Type_System.Typeclass

import java.io.File

object ImplicitParameters extends App {

  //implicit val current = "."

  def files(implicit directory: String): Either[String, List[File]] =
    try {
      val file = new File(directory)
      if(file.isDirectory)
        Right(file.listFiles().toList)
      else
        Right(List.empty[File])
    } catch {
      case e: Throwable => Left(e.getMessage)
    }

  //files.map(listOfFiles => listOfFiles foreach println)
}
