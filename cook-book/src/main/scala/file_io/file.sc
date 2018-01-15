import io.Source

val filename = "d:/code_2018/learn-scala/cook-book/data/test.sbt"

val file = Source.fromFile(filename)

println("trying")

try {

  val lines = file.getLines().toList
  for (line <- lines) {
    println(line)
  }
} catch {
  case e: Exception => {println(s"ERROR: $e")}
} finally {
  file.close()
}

def using[A <: { def close(): Unit}, B]
      (resource: A)(f: A => B): B = {
  try {
    f(resource)
  } finally {
    resource.close()
  }
}

def readTextFile(filename: String): Option[List[String]] = {
  try {
    val lines = using(Source.fromFile(filename)) {
      source =>
        source.getLines.toList
    }
    Some(lines)
  } catch {
    case e: Exception => None
  }
}

val lines = readTextFile(filename).get

lines.foreach { line =>
  println(line)
}
