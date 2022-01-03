package com.pluralsight.courses.The_Type_System.TypeBoundsVariance

abstract class Passenger

class BusinessPassenger extends Passenger
class EconomyPassenger extends Passenger

class CorporatePassenger extends BusinessPassenger

class AirplaneSeat[-T]

object Contravariance extends App{

  def reserveForCorporate(airplaneSeat: AirplaneSeat[CorporatePassenger]): Unit =
    println(s"Reserving seat")

  reserveForCorporate(new AirplaneSeat[CorporatePassenger])
  reserveForCorporate(new AirplaneSeat[BusinessPassenger])
}
