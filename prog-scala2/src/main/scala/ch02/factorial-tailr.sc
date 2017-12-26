/*
factorial with tail-recursive call
 */

import scala.annotation.tailrec

def factorial(i: Int): Long = {
  @tailrec
  def fact(i: Int, accu: Int): Long = {
    if (i <= 1)
      accu
    else
      fact(i-1, i*accu)
  }

  fact(i, 1)
}

(0 to 10).foreach( i => println(factorial(i)))
