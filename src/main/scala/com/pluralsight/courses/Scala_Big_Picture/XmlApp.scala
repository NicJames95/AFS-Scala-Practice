package com.pluralsight.courses.Scala_Big_Picture

// import scala.xml.Elem // build.sbt is where you can import dependencies
object XmlApp extends App {

  //  val person: Elem = <person>
  //  <firstName>John</firstName>
  //    <lastName>Doe</lastName>
  //    <emails>
  //    <email type="primary">john.doe@noone.com</email>
  //    <email type="secondary">john.doe@no1.com</email>
  //    </emails>
  //    <address>
  //    <street>595 Market Street</street>
  //      <city>San Francisco</city>
  //      <zip>94185</zip>
  //    </address>
  //  </person>

  //val seq: NodeSeq = person \ "firstName"
  //println(seq) // returns xml firstName

  // val seq2: NodeSeq = person \\ "email"
  // println(seq2) will print the types ("primary", "secondary")
  // seq2.map(email => println(email))

  // val seq3: NodeSeq = person \\ "city"     (\\) finds nested nodes in xml files
  // println(seq3)


}
