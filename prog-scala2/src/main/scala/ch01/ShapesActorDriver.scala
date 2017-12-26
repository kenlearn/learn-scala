package ch01.shapes

import akka.actor.{Props, Actor, ActorRef, ActorSystem}
import com.typesafe.config.ConfigFactory

private object Start

object ShapesActorDriver {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("DrawActorSystem", ConfigFactory.load())
    val drawer = system.actorOf(
      Props(new ShapesDrawerActor), "drawActor"
    )
    val driver = system.actorOf(
      Props(new ShapesActorDriver(drawer)), "drawService"
    )
    driver ! Start
  }
}

class ShapesActorDriver(drawerActor: ActorRef) extends Actor {
  import Messages._

  def receive = {
    case Start =>
      drawerActor ! Circle(Point(0,0), 3.0)
      drawerActor ! Rectangle(Point(0,0), 3, 4)
      drawerActor ! 3.14
      drawerActor ! Triangle(Point(0.0,0.0), Point(2.0,0.0), Point(1.0,2.0))
      drawerActor ! Exit
    case Finished =>
      println(s"ShapesActorDriver: clean up...")
      context.system.terminate()
    case response: Response =>
      println(s"ShapesDrawingDriver: Response = $response")
    case unexpected =>
      println(s"ShapesDrawingDriver: ERROR: Received an unexpected message = $unexpected")
  }
}

