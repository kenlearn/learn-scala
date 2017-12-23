import shapes._

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import java.time._

object Main extends App {
  val asys = ActorSystem("ShapeSystem")
  val shapeActor = asys.actorOf(Props[ShapeDrawingActor], name="shapeactor")

  shapeActor ! new Circle(new Point(0.0,0.0), 3.0)
  shapeActor ! new Rectangle(new Point(0.0,0.0), 3, 4)

  shapeActor ! 3.14
  shapeActor ! "exit"

  println(Instant.now)
  Thread.sleep(1000L)
  asys.terminate()
}
