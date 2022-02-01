package com.pluralsight.courses.Scala_Methods_Functions

/** Case classes are used to model immutable data can be constructed 
 * without the new keyword */
case class GOOGRecord(date: String,
                       open: Float,
                       high: Float,
                       low: Float,
                       close: Float,
                       adj_close: Float,
                       volume: Double)
