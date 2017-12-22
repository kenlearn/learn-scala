package ch01

object Upper1 extends App{

  val up1 = new Upper1
  println(up1.upper("A", "First", "Scala", "Program"))

  println(Upper2.upper("A", "Second", "Scala", "Program"))
}

class Upper1 {
  def upper(ss: String*): Seq[String] = {
    ss.map((s: String) => s.toUpperCase())
  }
}

object Upper2 {
  def upper(ss:String*) = ss.map(_.toUpperCase())
}
