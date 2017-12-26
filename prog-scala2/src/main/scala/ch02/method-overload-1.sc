object StringUtil {
  def joiner(strings: String*): String = strings.mkString("-")

  def joiner(strings: List[String]): String = joiner(strings: _*)

}

import StringUtil._

println(joiner(List("Scala", "java", "golang")))
