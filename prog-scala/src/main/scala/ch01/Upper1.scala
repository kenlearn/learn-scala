package ch01

object Upper1 extends App{

  val up1 = new Upper
  println(up1.upper("A", "First", "Scala", "Program"))

}

class Upper {
  def upper(ss: String*): Seq[String] = {
    ss.map((s: String) => s.toUpperCase())
  }
}
