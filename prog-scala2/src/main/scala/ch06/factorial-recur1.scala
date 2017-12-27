package ch06

import scala.annotation.tailrec

object factorialRecur1 {

  def main(args: Array[String]): Unit = {
    (1 to 10).foreach(x =>
    println(s"$x:\t${factorialTailCall(x)}"))
  }

  def factorial(i: Int): Long = {
    if (i == 1)
      i
    else
      i * factorial(i-1)
  }

  def factorialTailCall(i: Int): Long = {
    @tailrec
    def fact(i: Int, accu: Long): Long = {
      if ( i==1 )
        accu
      else
        fact(i-1, i*accu)
    }

    fact(i, 1)
  }
}
