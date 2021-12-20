package com.pluralsight.courses.Scala_Methods_Functions
/** Case classes are used to model immutable data and can be constructed without the NEW keyword */
case class StockRecord(date: String,
                       open: Float,
                       high: Float,
                       low: Float,
                       close: Float,
                       ticker: String)
