package com.pluralsight.courses.Scala_Asynchronous_Programming

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object ContestApplicationAsync {

  def main(args: Array[String]): Unit = {

    val firstParticipant = registerParticipant(1, 2)

    firstParticipant
      .foreach(registered =>

      println(s"[${Thread.currentThread()}] main method, participant registered: $registered")
      )

    println(s"[${Thread.currentThread()}] main method, performing other operations.")

    // The sleep statement is not required if running using from SBT.
    Thread.sleep(10000L)
  }

  def registerParticipant(userId: Int, contestId: Int): Future[Boolean] = Future {
    println(s"[${Thread.currentThread()}] registerParticipant")

    val contestInfoFuture = fetchContestInfo(contestId)
    val userInfoFuture = fetchUserInfo(userId)

    for {
      cInfo <- contestInfoFuture
      uInfo <- userInfoFuture
    } yield {
      // Perform some operations on contestInfo and userInfo, or combine them.
      println(s"[${Thread.currentThread()}] \t contestInfo: " + cInfo + "\tuserInfo: " + uInfo)
    }

    true
  }

  def fetchContestInfo(contestId: Int): Future[ContestInfo] = Future {
    println(s"[${Thread.currentThread()}] fetchContestInfo")

    // logic for fetching contest information
    Thread.sleep(2000L)
    ContestInfo(contestId, "Weekly Contest")
  }

  def fetchUserInfo(contestId: Int): Future[UserInfo] = Future {
    println(s"[${Thread.currentThread()}] fetchUserInfo")
    
    // logic for fetching user information
    UserInfo(contestId, "Alex", "alex.foo@email.com")
  }
  
  case class UserInfo(id: Int, name: String, email: String)
  case class ContestInfo(id: Int, title: String)

}
