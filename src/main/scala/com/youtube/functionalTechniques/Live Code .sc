import practice.ScalaWork_Questions.Person

import scala.util.Try

object Main {
  def main(args: Array[String]): Unit = ???
  private def go(emit: () => Seq[RawUser]): Result = ???
  private def toResult(v: DomainUser): Result = ???

  private def transform(r: RawUser): Either[TransformError, DomainUser] = {
    val maybePerson: Either[TransformError, Person] = r.person
    val maybePhone: Either[TransformError, PhoneNumber] = PhoneNumber.from(r.phone)

    // (maybePerson) |@| (maybePhone)(DomainUser))

    for {
      person <- maybePerson
      phoneNumber <- maybePhone
    } yield DomainUser(person, phoneNumber)
  }
}

object Source {
  def emit(conf: Config)(): Seq[RawUser] = ???
    // do something cool with config
    // RawData.generateRawUsers imported for tutorial
}

trait Config
case class FileConfig() extends Config

object Config {
  def current: Config = FileConfig()
}

case class Result(successes: Int, failures: Int)
case class TransformError(error: String)

case class DomainUser(
                     person: Person,
                     phoneNumber: PhoneNumber
                     )

case class PhoneNumber(
                      countryCode: Int,
                      areaCode: Int,
                      prefix: Int,
                      lineNumber: Int
                      ) {
  override def toString = s"$countryCode ($areaCode) $prefix-$lineNumber"
}

object PhoneNumber {
  private val pattern = """(\d{1})-(\d{3})-(\d{3})-(\d{4})""".r
  private def toInt(s: String): Either[TransformError, Int] = {
    Try(s.toInt).toEither.left.map(e => TransformError(e.getMessage))
  }

  def from(phoneString: String): Either[TransformError, PhoneNumber] = {
    phoneString match {
      case pattern(code, area, prefix, line) => {
        // (toInt(code) |@| toInt(area) |@| toInt(prefix) |@| toInt(line))(PhoneNumber) scalaz syntax
        Right(PhoneNumber(code.toInt, area.toInt, prefix.toInt, line.toInt))
      }
      case _ => Left(TransformError(s"$phoneString didn't parse"))
    }
  }
}

case class Person(firstName: String, lastName: String)

case class RawUser(
     fullName: String,
     email: String,
     phone: String,
     streetAddress: String,
     city: String,
     zipCode: String) {
  lazy val person: Either[TransformError, Person] = {
    fullName.split(" ").toList match {
      case first :: last :: Nil => Right(Person(first, last))
      case _ => Left(TransformError(s"Failed parsing person"))
    }
  }
}
