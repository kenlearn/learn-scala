package progscala2.ch01

object Upper {
  def upper(strings: Array[String]) = strings.map(_.toUpperCase)

  def main(args: Array[String]): Unit = {
    println(upper(args).mkString(" "))
  }
}

