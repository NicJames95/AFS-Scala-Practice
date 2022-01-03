package com.pluralsight.courses.The_Type_System.Typeclass

import java.time.LocalDateTime
import java.util.UUID

sealed trait Plan
case object Monthly extends Plan
case object BiAnnual extends Plan
case object Annual extends Plan

sealed trait Subscribable

case class Channel(name: String) extends Subscribable
case class TVPackage(name: String, channels: Set[Channel]) extends Subscribable

case class SubscriptionPeriod(startDate: LocalDateTime, endDate: LocalDateTime)
case class Subscription(
                       name: String,
                       defaultTVPackages: Map[TVPackage, Plan],
                       additionalTVPackages: Map[TVPackage, Plan],
                       additionalChannels: Map[Channel, Plan],
                       subscriptionPeriod: SubscriptionPeriod
                       ) extends Subscribable

case class Subscribed(name: String)
case class User(name: String, accountId: UUID)

trait Subscriber[T] {

  def subscribe(subscribable: T, user: User): Subscribed
}

object Subscriber {

  implicit val channelSubscriber: Subscriber[Channel] = new Subscriber[Channel] {

    override def subscribe(subscribable: Channel, user: User): Subscribed = {
      Subscribed(s"CH${subscribable.name}") //Perform some process on Channels
    }
  }

  implicit val tvPackageSubsriber: Subscriber[TVPackage] = new Subscriber[TVPackage] {

    override def subscribe(subscribable: TVPackage, user: User): Subscribed = {
      Subscribed(s"TVP${subscribable.name}") //Perform some process on TVPackages
    }
  }

  implicit val subscriptionSubscriber: Subscriber[Subscription] = new Subscriber[Subscription] {

    override def subscribe(subscribable: Subscription, user: User): Subscribed = {
      Subscribed(s"SUB${subscribable.name}") //Perform some process on Subscriptions
    }
  }
}


object SubscriberOps {

  def subscribe[T](subscribable: T, user: User)(implicit ev: Subscriber[T]): Subscribed =
    ev.subscribe(subscribable, user)
}

object SubscriptionDemo extends App {
  import SubscriberOps._

  val user = User("Alice", UUID.randomUUID())
  val channelOne = Channel("One")

  val tvPackageSports = TVPackage("SportsPack", Set(Channel("SportsOne"), channelOne))

  val userSubscribed = subscribe(channelOne, user)
  println(s"Subscribed name: ${userSubscribed.name}")

  val sportsUserSubscribed = subscribe(tvPackageSports, user)
  println(s"Subscribed name: ${sportsUserSubscribed.name}")
}