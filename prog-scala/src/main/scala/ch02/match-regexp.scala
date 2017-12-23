/*
match regex
 */


object Main8 {
  val BookRE = """BooK: title=([^,]+),\s+authors=(.+)""".r
  val MagazineRE = """Magazine: title=([^,]+),\s+issue=(.+)""".r

  val catalog = List(
    "Book: title=Programming Scala, authors=Dean Wampler, Alex Payne",
    "Magazine: title=The New Yorker, issue=January 2009",
    "Book: title=War and Peace, authors=Leo Tolstoy",
    "Magazine: title=The Atlantic, issue=February 2009",
    "BadData: text=Who put this here??"
  )

  def main(args: Array[String]): Unit = {
    for (item <- catalog) {
      item match {
        case BookRE(title, authors) =>
          println("Book \"" + title + "\", written by " + authors)
        case MagazineRE(title, issue) =>
          println("Magazine \"" + title + "\", issue " + issue)
        case entry =>
          println("Unrecognized entry: " + entry)
      }
    }
  }
}

