package ch01.shapes

object Messages {
  object Exit
  object Finished
  case class Response(message: String)
}

import akka.actor.Actor

class ShapesDrawerActor extends Actor {
  import Messages._

  def receive = {
    case s: Shape =>
      s.draw(str => println(s"ShapesDrawerActor: $str"))
      sender ! Response(s"ShapesDrawerActor: $s drawn")
    case Exit =>
      println(s"ShapesDrawerActor: exiting...")
      sender ! Finished
    case unexpected =>
      val response = Response(s"ERROR: unknown message: $unexpected")
      println(s"ShapesDrawerActor: $response")
      sender ! response
    }
}
