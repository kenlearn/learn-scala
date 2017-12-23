package ch02

object Factorial {

  def main(args: Array[String]): Unit = {
    println(fatorial(4))
    println(fatorial(5))
  }

  /*
    define inner function
      function that nested inside function
   */

  def fatorial(i: Int): Int = {
    def fact(i: Int, accu: Int): Int = {
      if (i <=1 )
        accu
      else
        fact(i-1, i*accu)
    }

    fact(i, 1)
  }
}
