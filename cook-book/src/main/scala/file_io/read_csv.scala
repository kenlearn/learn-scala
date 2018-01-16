import io.Source
import scala.collection.mutable.ArrayBuffer

object ReadCSV extends App {
  val fname = "d:/temp/f1.dat"
  val source = Source.fromFile(fname)
  val rows = ArrayBuffer[Array[String]]()

  using(Source.fromFile(fname)) { source =>
    for (line <- source.getLines) {
      rows += line.split(",").map(_.trim)
    }
  }

/* // alternative, use zipWithIndex
  for ((line, count) <- source.getLines.zipWithIndex) {
    rows += line.split(",").map(_.trim)
  }
*/

  source.close
  rows foreach { row =>
    println(s"${row(0)} ${row(1)} ${row(2)} ${row(3)}")
  }

  def using[A <: {def close(): Unit}, B]
    (resource: A)(f: A => B): B = {
      try {
        f(resource)
      } finally {
        resource.close
      }
    }
}
