def factorial(i: Int): Long = {
  def fact(i: Int, accu: Long): Long = {
    if ( i<= 1 )
      accu
    else
      fact(i-1, i*accu)
  }

  fact(i, 1)
}

(0 to 5).foreach(i => println(factorial(i)))
