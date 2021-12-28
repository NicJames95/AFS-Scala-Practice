package com.pluralsight.courses.Scala_Asynchronous_Programming

object ContestApplicationTwoThreads {

  def main(args: Array[String]): Unit = {
    val firstParticipant = registerParticipant(1, 2)

    println(s"[${Thread.currentThread()}] main method, performing other operations.")
  }

  def registerParticipant(userId: Int, contestId: Int): Boolean = {
    println(s"[${Thread.currentThread()}] registerParticipant")

    var contestInfo: ContestInfo = null
    var userInfo: UserInfo = null

    val t1 = threaded {
      contestInfo = fetchContestInfo(contestId)
    }

    val t2 = threaded {
      userInfo = fetchUserInfo(contestId)
    }

    // After main thread starts the new thread, it calls join method, it halts the execution of the main thread until
    // newly created Threads complete their execution.
    // Join puts the main thread into the waiting state until newly created threads terminate
    t1.join()
    t2.join()

    // Perform some operations of contestInfo and userInfo, or combine them.
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

  def threaded(exec: => Any): Thread = {
    val child = new Thread {
      override def run(): Unit = exec
    }

    // Start method eventually results in executing the run method from the new thread, with this OS is notified that
    // thread must start executing.
    child.start()
    child
  }

  case class UserInfo(id: Int, name: String, email: String)
  case class ContestInfo(id: Int, title: String)

}
