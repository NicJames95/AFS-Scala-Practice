import java.net.http.{HttpRequest, HttpResponse}
import java.util.concurrent.Future

type WebRequest = HttpRequest => Future[HttpResponse]

def serializeCustomer: Customer => HttpResponse = ???
def deSerializePerson: HttpRequest => Person = ???

def createCustomer: Person => Future[Customer] = ???

def saveCustomer: Customer => Future[Customer] = ???

val fstStep: HttpRequest => Future[Customer] =
  deSerializePerson andThen
    createCustomer

val customerSaved: HttpRequest => Future[Customer] = hr =>
  fstStep(hr).flatMap(saveCustomer)

val fullRequest: HttpRequest => Future[HttpResponse] = hr =>
  customerSaved(hr).map(serializeCustomer)

// def flatMap[A, B](f: A => Future[B]): Future[B]
// def map(f: A => B): Future[B]

/*
f: A => Future[B]
g: B => Future[C]

g superCompose f : A => Future[C]
- read more about
http://eed3si9n.com/herding-cats/composing-monadic-functions.html
https://underscore.io/books/scala-with-cats/
*/

class DatabaseConnection

val databaseConnection = new DatabaseConnection

object DataAccess {
  def saveCustomer(databaseConnection: DatabaseConnection)
                  (c: Customer): Customer = ???
}

class DataAccess(databaseConnection: DatabaseConnection) {
  def saveCustomer(c: Customer): Customer = ???
}

object DatabaseAccessImplicit {
  def saveCustomer(c: Customer)
                  (implicit db: DatabaseConnection): Customer = ???
}

val dac = new DataAccess(databaseConnection)

// val saveCustomer: Customer => Customer = DataAccess.saveCustomer(databaseConnection)
// val saveCustomer: Customer => Customer = dac.saveCustomer(databaseConnection)
val saveCustomer: Customer => Customer =
  DatabaseAccessImplicit.saveCustomer

implicit val dbConnection = new DatabaseConnection



val registerCustomer: WebRequest =
  deSerializePerson andThen
    createCustomer andThen
    saveCustomer andThen
    serializeCustomer

case class Person(name: String)
case class Customer(customerNumber: Int, p: Person)

trait Serializer {
  def serialize(c: Customer): HttpResponse
  def deserialize(input: HttpRequest): Person
}

class WebController(
                   service: ApplicationService,
                   serializer: Serializer
                   ) {
  def register(p: HttpRequest): HttpResponse = {
    val person = serializer.deserialize(p)
    val c = service.registerCustomer(person)
    serializer.serialize(c)
  }
}

class ApplicationService(dataStore: CustomerRepo) {

  def registerCustomer(p: Person): Customer = {
    // validate them?
    // Generate a unique customer number?
    val c = Customer(1, p)
    dataStore.saveCustomer(c)
    c
  }
}

trait CustomerRepo {
  def saveCustomer(p: Customer): Unit
}

abstract class Abstracted[F[_] : Mappable] {
  def serializeCustomer: Customer => HttpResponse = ???
  def deSerializePerson: HttpRequest => Person = ???
  def createCustomer: Person => F[Customer] = ???
  def saveCustomer: Customer => F[Customer] = ???
}

trait Mappable[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
}

implicit def futureMappable = new Mappable[Future] {
  def map[A, B](fa: Future[A])(f: A => B): Future[B] =
    fa.map(f)
  def flatMap[A, B](fa: Future[A])(f: A => Future[B]): Future[B] =
    fa.flatMap(f)
}

implicit def completeableFutureMappable = new Mappable[CompleteableFuture] {
  def map[A, B](fa: CompleteableFuture[A])(f: A => B): CompleteableFuture[B] =
    fa.thenApply(a => f(a))
  def flatMap[A, B](fa: CompleteableFuture[A])(f: A => CompleteableFuture[B]): CompleteableFuture[B] =
    fa.thenCompose(a => f(a))
}

val first: HttpRequest => F[Customer] =
  deSerializePerson andThen
    createCustomer

val fullyRequest: HttpRequest => F[HttpResponse] = hr =>
  first(hr)
    .flatMap(saveCustomer)
    .map(serializeCustomer)

val withAFuture = new Abstracted[Future] {...}
val whatTypeIsThis: HttpRequest => Future[HttpResponse] =
  withAFuture.fullRequest

/* Implicit type conversions */
case class Cat(name: String)
case class Dog(name: String, status: String)

def cleanDog(dog: Dog): Dog =
  dog.copy(status = "clean with hose")

val ruby = Cat("Ruby")

cleanDog(ruby)

implicit def catToDog(cat: Cat): Dog = Dog(cat.name, "clean")

