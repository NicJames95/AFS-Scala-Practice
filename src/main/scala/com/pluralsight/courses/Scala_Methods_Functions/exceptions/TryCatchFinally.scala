package com.pluralsight.courses.Scala_Methods_Functions.exceptions

import scala.io.{Source, BufferedSource}
import java.io.FileNotFoundException
import java.io.IOException

object TryCatchFinally extends App {
 def getLinesFromFile(filename: String): List[String] = {
   var sourcePath: BufferedSource = null

   try {
     sourcePath = Source.fromFile(filename)

     println("Reading file completed")

     sourcePath.getLines.toList

   } catch {
     case ex: FileNotFoundException => {
       println("File not found")
       List()
     }

     case ex: IOException => {
       println("Input/Output Exception")
       List()
     }
   } finally {
     /** Even though finally is executed the ACTUAL RESULT VALUE that we get when we run this method is from
      * the TRY BLOCK, which is confusing. AVOID RETURNING RESULTS FROM FINALLY BLOCKS. */
     println("Close file if it has been opened")
     if (sourcePath != null) {
       println("Closing file")
       sourcePath.close()
     }
     List("avoid", "result", "expressions", "from", "the", "finally", "block")
   }
 }

  val lines = getLinesFromFile("src/main/resources/dividendStocks.csv")
  println("-------------------Displaying lines")
  lines.foreach(println)
}
