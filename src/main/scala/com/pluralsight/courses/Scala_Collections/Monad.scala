package com.pluralsight.courses.Scala_Collections

object Monad extends App {

  trait Mappable[B] {
    def map[A](f: A => B): Mappable[B]
  }

  trait Functor[F[_]] {
    def map[A, B](f: A => B): F[B]
  }

  trait FlatMappable[B] extends Mappable[B] {
    def apply[A](a: A): FlatMappable[A]
    def flatMap[A](f: A => FlatMappable[B]): FlatMappable[B]
  }

  trait Monad[F[_]] extends Functor[F] {
    def apply[A](a: A): F[A]
    def flatMap[A, B](f: A => F[B]): F[B]
  }

  class List[A] extends Monad[List] {
    override def apply[A](a: A): List[A] = ???
    override def flatMap[A, B](f: A => List[B]): List[B] = ???
    override def map[A, B](f: A => B): List[B] = ???
  }
  /** Monad
   * 1. Operate on a parametrized type (container/ type constructor)
   * 2. Be able to construct itself from that type (unit)
   * 3. Provide the flatMap operation (bind)
   *NB. So that varied types need only provied these things to power REUSE and
   * CONSISTENCY of application
   *
   * Lists
   * List[T]    #1
   * List(x, y, z)      #2
   * flatMap[B](f: A => List[B]): List[B]     #3
   *
   * Options
   * Option[T]    #1
   * Option.apply(x); Some(x); None     #2
   * flatMap[B](f: A => Option[B]): Option[B]     #3
   * */

//  Option("thing").map(_.toUppercase)
//    .map(_.reverse)
//    .map(_.replace("G", "K"))
//    .map(_.replace("HT", "GHT"))
// Some("KNIGHT")

//  Some(Some("thing")).flatten // Some("thing")
//  Some(None).flatten    // None

  /** FINDS A CUSTOMER USING OPTIONS FOR (CUSTOMER, ADDRESS, POSTCODE) RETURNS A SHIPPINGLABEL
   * val orders = List[Order](
   * Order("Albert", OrderDetails("SKU0012", 23)),
   * Order("Beatriz", OrderDetails("SKU0122" 1)),
   * Order("Carol", OrderDetails("SKU0234", 2)),
   * Order("Sherlock", OrderDetails("SKU00111", 1))
   * )
   *
   * def generateShippingDetails(): List[ShippingLabel] = {
   *  orders.map(order =>
   *    database.find(order.customerName).flatMap(customer =>
   *      customer.address.flatMap(address =>
   *        address.postcode.map(postcode =>
   *          ShippingLabel(customer.name, address.street, postcode))))).flatten
   *          }
   *          */

  /** FOR COMPREHENSIONS
   * for (i <- 0 to 5) yield i ============ (i <- 0 to 5).map(i => i)
   *
   * for {                                  (0 to 5).flatMap {
   *  i <- 0 to 5                             i => (0 to 5).map {
   *  j <- 0 to 5                               j => (i, j)
   * } yield (i, j)                           }
   *                                         }
   *
   *
   *  def generateShippingLabels(): List[ShippingLabel] = {
   *  for {
   *    order <- orders
   *    customer <- database.find(order.customerName)
   *    address <- customer.address
   *    postcode <- address.postcode
   *  } yield {
   *    ShippingLabel(customer.name, address.street, postcode)
   *  */


}
