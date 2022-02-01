package practice

import scala.language.postfixOps

object Hangman {

  def main(args: Array[String]): Unit = {
    println("Hangman!")
  }

  class Noose(val stage: Int) {
    val STAGES = Array("")

    def isComplete(): Boolean = {
      stage == STAGES.length - 1
    }

    def advance(): Unit = {
      if (!isComplete())
        stage
    }
  }


}
