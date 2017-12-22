package ch01

object Upper3 {

  def main(args: Array[String]): Unit = {
    args.map(_.toUpperCase()).foreach(printf("%s ", _))
    println("")
  }

}
