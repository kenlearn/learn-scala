package progscala2.concurrency.akka

import scala.util.{Try, Success, Failure}
import scala.util.control.NonFatal
import scala.concurrent.duration._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem,
      Props, OneForOneStrategy, SupervisorStrategy}
import akka.pattern.ask
import akka.util.Timeout

class ServerActor extends Actor with ActorLogging {
  import Messages._

  implicit val timeout = Timeout(1.seconds)


  override val supervisorStrategy: SupervisorStrategy = {
    val decider: SupervisorStrategy.Decider = {
      case WorkerActor.CrashException => SupervisorStrategy.Restart
      case NonFatal(_) => SupervisorStrategy.Resume
    }
    OneForOneStrategy()(decider orElse super.supervisorStrategy.decider)
  }

  var workers = Vector.empty[ActorRef]

  def receive: Receive = initial

  val initial: Receive = {
    case Start(numOfWorkers) =>
      workers = ((1 to numOfWorkers) map makeWorker ).toVector
      context become processRequest   // 6
  }

  val processRequest: Receive = {   // 7
    case c @ Crash(n) => workers(n % workers.size) ! c
    case DumpAll =>   //8
      Future.foldLeft(workers.map(_ ? DumpAll))(Vector.empty[Any])(_ :+ _)
          .onComplete(askHandler("State of the workers"))
    case Dump(n) =>
      (workers(n%workers.size) ? DumpAll).map(Vector(_))
          .onComplete(askHandler(s"State of worker ${n}"))
    case request: Request =>
      val key = request.key.toInt
      val index = key % workers.size
      workers(index) ! request
    case Response(Success(message)) => printResult(message)
    case Response(Failure(ex)) => printResult(s"Error! ${ex}")
  }

  def askHandler(prefix: String): PartialFunction[Try[Any], Unit] = {
    case Success(suc) => suc match {
      case vect: Vector[_] =>
        printResult(s"${prefix}\n")
        vect foreach {
          case Response(Success(message)) =>
            printResult(s"${message}")
          case Response(Failure(ex)) =>
            printResult(s"Error! Success received wrapping ${ex}")
        }
      case _ => printResult(s"Bug! Expected a vector, got ${suc}")
    }
    case Failure(ex) => printResult(s"Error! ${ex}")
  }

  protected def printResult(message: String): Unit = {
    println(s"<< ${message}")
  }

  protected def makeWorker(i: Int) =
    context.actorOf(Props[WorkerActor], s"worker-${i}")

}

object ServerActor {    // 9
  def make(system: ActorSystem): ActorRef =
    system.actorOf(Props[ServerActor], "server")
}
