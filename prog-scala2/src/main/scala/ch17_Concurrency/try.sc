import scala.util.{Try, Success, Failure}
import java.net.URL

def parseURL(url: String): Try[URL] = Try(new URL(url))

def printResult(s: String): Unit = println(s"URL is: ${s}")

parseURL("http://www.google.com") match {
    case s @ Success(_) => printResult(s.get.toString)
    case e @ Failure(_) => println(s"Error: ${e}")
}
