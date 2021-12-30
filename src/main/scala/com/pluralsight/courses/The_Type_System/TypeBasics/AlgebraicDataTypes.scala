package com.pluralsight.courses.The_Type_System.TypeBasics

object AlgebraicDataTypes extends App
{
  /** Sum types
   * sealed trait A
   * case object X extends A
   * case object Y extends A
   * case object Z extends A
   *
   * Product types
   * case class Task(...)
   *
   *
   *  sealed trait TaskStatus
   *  case object Pending extends TaskStatus
   *  case object InProgress extends TaskStatus
   *  case object Completed extends TaskStatus
   *
   *  def returnsTaskStatus: TaskStatus
   *  returnsTaskStatus() match {
   *    case Pending =>
   *    case InProgress =>
   *    case Completed =>
   * }
   * */

  sealed trait TaskStatus
  case object Pending extends TaskStatus
  case object InProgress extends TaskStatus
  case object Completed extends TaskStatus

  case class Task(name: String, status: TaskStatus, isPriority: Boolean)

  def manageTask(task: Task): Unit = {
    val taskStatus = task.status

    taskStatus match {
      case Pending if task.isPriority == true => println(s"assigning Task: ${task.name}")
      case Pending => println(s"Task is $Pending")
      case InProgress => println(s"Task is $InProgress")
      case Completed => println(s"Task is $Completed")
    }
  }

  def labelPriorityTask(task: Task, labelString: String): Task = {
    task match {
      case Task(name, status, true) => Task(s"[$labelString] - $name", status, true)
      case task: Task => task
    }
  }

  val task = Task("Decide the title", Pending, true)
  manageTask(task)
  println(labelPriorityTask(task, "Important").name)

}
