import java.io._

object CopyBytes extends App {
  var in = None: Option[FileInputStream]
  var out = None: Option[FileOutputStream]

  try {
    in = Some(new FileInputStream("/tmp/bayes_101.png"))
    out = Some(new FileOutputStream("/tmp/bayes_102.png"))

    var c = 0

    while ({ c = in.get.read; c != -1}) {
      out.get.write(c)
    }
  } catch {
    case e: IOException => println(e)
  } finally {
    println("clean up...")
    if (in.isDefined) in.get.close
    if(out.isDefined) out.get.close
  }
}