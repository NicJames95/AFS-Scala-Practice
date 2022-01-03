package com.pluralsight.courses.The_Type_System.TypeBoundsVariance

abstract class Passenger2
class BusinessPassenger2 extends Passenger2
class CorporatePassenger2 extends BusinessPassenger2
class EconomyPassenger2 extends Passenger2

class AirplaneSeat2[-T >: CorporatePassenger2 <: Passenger2]

object TypeBounds extends App{

  val corporatePassengerSeat = new AirplaneSeat2[CorporatePassenger2]()
  val businessPassengerSeat = new AirplaneSeat2[BusinessPassenger2]()
  val passengerSeat = new AirplaneSeat2[Passenger2]()

  //val stringSeat = new AirplaneSeat[String]()
  // val economyPassengerSeat = new AirplaneSeat[EconomyPassenger]()
  /** Doesn't compile as AirplaneSeat is TYPE-BOUND to types LESS THAN(<:) Passenger
   * and GREATER THAN(>:) CorporatePassenger
   */

}
