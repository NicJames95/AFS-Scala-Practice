//case class Cat(name: String)
//
//val a : Option[Cat] = Some(Cat("name1"))
//
//a.map{ c => c.copy(name = "name2") } Some(Cat(name2)): scala.Option[Cat]
//
//// Option[A] => Set[A]
//a.foldLeft(Set.empty[Animal]) {
//  case (out, in: Cat) if in.name == "name1" => out + in
//  case (out, _) => out
//}
//
//map => keep same structure
//flatMap => Option(Option( => Option))
//fold/foldLeft/foldRight => changing structure
//  Option => Set
//
//Monad =>
//  Function takes in one parameter
//  1) define unit function : M[A] => unit
//  2) define flatMap function : M[A] => M[B]
//  eg: Option, Future
//  Project eg: SvcFlowOut
//
//Future: Non-blocking code, Asynchoronous calls
//Success[A], Failure[Exception]
//def databaseCall (a: Object): Future[Boolean]
//def outsideSystem(a: Object): Future[String]
//Case 1: First db call, if success then outside system else no outside databaseCall
//  // one way
//  val output: Future[Option[String]] = databaseCall(a).flatMap { bool =>
//    if(bool) {
//      outsideSystem(a).map(Some(_))
//    } else {
//        Future.successful(None)
//    }
//  }
//// second way
//val output = for {
//  bool <- databaseCall(a)
//  if bool
//  str <- oustideSystem(a)
//} yield str
//
//Case 2: Db call and system call
//  Future.sequence(databaseCall(a), outsideSystem(a))
//
//Case 3: Call database, if success, return "Success" else Failure
//  databaseCall(a).map { bool =>
//    if(bool) "Success"
//    else "Failure"
//  }
//
//-transform
//  databaseCall(a).transform {
//    case Success(bool) => if bool Success("Success") else Success("Failure")
//    case Failure(_) => Success("Failure")
//  }
//-transformWith : same as transform but you are making another Future call when unwrapping
//
//Either => Left and Right
//
//AsyncChangePropagator: Input change should run flows impacted
//  60 flows
//  Flow => Hub(ExternalSvc), Data(ExternalSvc, Dafs), Result(BusinessFunctions(Bf), RuleSvc)
//  Event => Data(Hub, Data), Result | app, member | dependencies
//    eg: Event A (dependent on) -> Event B, Event C
//  Event A:
//        Preparator : Application => Input
//        Comparator : Compare function : ignore things if business need
//        Flow : Input => Future[EventA]
//  prune:
//    removes the dependent(child) events when there is issues in the parent events
//    Event B getting calculated and has validation error when computing the new input
//  ExecutionSequence : Set of events to compute
//  Debugging: EventInputCalculator