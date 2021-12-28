package com.pluralsight.courses.Scala_Asynchronous_Programming

object ContestApplication {

  def main(args: Array[String]): Unit = {
    val firstParticipant = registerParticipant(1, 2)
    println(s"[${Thread.currentThread()}] main method, performing other operations.")
  }

  def registerParticipant(userId: Int, contestId: Int): Boolean = {
    println(s"[${Thread.currentThread()}] registerParticipant")

    val contestInfo = fetchContestInfo(contestId)
    val userInfo = fetchUserInfo(userId)

    //Perform some operations on contestInfo and userInfo, or combine them.
    println(s"[${Thread.currentThread()}] \t contestInfo: " + contestInfo + "\tuserInfo: " + userInfo)

    true
  }

  def fetchContestInfo(contestId: Int): ContestInfo = {
    println(s"[${Thread.currentThread()}] fetchContestInfo")

    // logic for fetching contest information

    ContestInfo(contestId, "Weekly Contest")
  }

  def fetchUserInfo(contestId: Int): UserInfo = {
    println(s"[${Thread.currentThread()}] fetchUserInfo")

    // logic for fetching user information

    UserInfo(contestId, "Alex", "alex.foo@email.com")
  }

  case class UserInfo(id: Int, name: String, email: String)
  case class ContestInfo(id: Int, title: String)

}
