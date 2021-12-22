package com.pluralsight.courses.Scala_TypeClasses_Parametrization.typeParameterization

import com.pluralsight.courses.Scala_TypeClasses_Parametrization.typeParameterization.HttpUtils.HttpVerb

object HttpUtils {

  sealed trait HttpVerb
  case object GET extends HttpVerb
  case object PUT extends HttpVerb
  case object POST extends HttpVerb

  def asHttpVerb(httpVerb: String): HttpVerb =
    httpVerb.toLowerCase match {
      case "get" => GET
      case "post" => POST
      case "put" => PUT
      case other => throw new IllegalArgumentException(s"No equivalent HttpVerb for $other")
    }
}
  object CommonParameterizedTypes {
    import scala.util.{Try, Success, Failure}

    def main(args: Array[String]): Unit = {

      def toHttpVerb(httpVerb: String): Either[Throwable, HttpVerb] = // Option[HttpVerb] = //HttpVerb = HttpUtils.asHttpVerb(httpVerb)
        Try {
          HttpUtils.asHttpVerb(httpVerb)
          } match {
          case Success(value) => Right(value)
          case Failure(exception) => Left(exception)
        }// .toOption       //match {
//          case Success(value) => Some(value)
//          case Failure(_) => None
//        }
      println(toHttpVerb("get"))
      println(toHttpVerb("got"))
    }
  }


