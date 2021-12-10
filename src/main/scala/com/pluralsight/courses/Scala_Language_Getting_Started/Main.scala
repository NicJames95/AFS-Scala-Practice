package com.pluralsight.courses.Scala_Language_Getting_Started

object Main {
  def main(args: Array[String]): Unit = {
    // money "USD 100"
    val Array(code: String, value: String) = args(0).split("\\s")
    val valueAsDouble: Double = value.toDouble
    if (!Set("CAD", "NZD").contains(code)) {
      println("Supported Currencies are CAD, and NZD")
      sys.exit()
    }
    // val utils: Utils = new Utils() // instantiating Utils to use class


    // val rate: Double = utils.getRateFrom(code) // call using Utils class
    val rate: Double = Utils.getRateFrom(code) // call using Utils object
    println(args(0) + " = USD " + (rate * valueAsDouble))
  }

  class Utils {
    private val cadToUsd: Double = 1 / 1.30
    private val nzdToUsd: Double = 1 / 1.50

    def getRateFrom(code: String): Double = {
      println("getting rate from " + code)
      code match {
        case "NZD" => nzdToUsd
        case "CAD" => cadToUsd
      }
    }
  }

  object Utils {
    private val cadToUsd: Double = 1 / 1.30
    private val nzdToUsd: Double = 1 / 1.50

    def getRateFrom(code: String): Double = {
      println("getting rate from " + code)
      code match {
        case "NZD" => nzdToUsd
        case "CAD" => cadToUsd
      }
    }
  }

}
