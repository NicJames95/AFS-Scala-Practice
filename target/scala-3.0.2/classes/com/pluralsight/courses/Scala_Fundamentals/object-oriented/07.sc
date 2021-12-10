object MyApplication {
  def main(args: Array[String]): Unit = {
    println("I am entry point to the applications")
    args.foreach(println)
  }
}
MyApplication.main(Array("hello", "world!"))