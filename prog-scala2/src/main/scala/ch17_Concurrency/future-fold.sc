import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global

val futures = (0 to 9).map {
    i => Future {
        val s = i.toString
        println(s"=>${s}")
        s
    }
}

val f = Future.reduceLeft(futures)((s1,s2) => s1 + s2)

val n = Await.result(f, Duration.Inf)

