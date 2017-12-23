/*
play with Enumeration
 */

object Breed extends Enumeration {
  val doberman = Value("Doberman Pinscher")
  val yorkie = Value("Yorkshire Terrier")
  val scottie = Value("Scottish Terrier")
  val dane = Value("Great Dane")
  val portie = Value("Portuguese Water Dog")
}

object Main9 {
  def main(args: Array[String]): Unit = {

    for (breed <- Breed.values) println(breed.id + "\t" + breed)

    Breed.values.filter(_.toString.endsWith("Terrier")).foreach(println)

    import Breed._
    println(dane)
  }
}