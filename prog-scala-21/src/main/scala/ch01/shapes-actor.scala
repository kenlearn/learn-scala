package ch01

import akka.actor._
  import akka.actor.Actor._

class ShapeDrawingActor extends Actor {
  def receive = {
        case s: Shape => s.draw()
        case x: Any => println("Error: unkown message: %s".format(x))
      }
    }