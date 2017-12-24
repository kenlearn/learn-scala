# Learning Scala

### Books and Resource
- [Programming Scala, 2nd Edition](https://www.safaribooksonline.com/library/view/programming-scala-2nd/9781491950135/)
- [Tour of Scala (official)](https://docs.scala-lang.org/tour/tour-of-scala.html)
- [Scala School (twitter)](http://twitter.github.io/scala_school/)
- [Effective Scala (twitter)](http://twitter.github.io/effectivescala/)


### first scala
```scala
object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello World")
  }
}
```

### for loop
```scala
for ( i <- 1 to 5; j <- 1 to 5 ) {
    println (i, j, i*j)
}

//  filter
for (book <- books 
    if book.contains("Scala")
) println(book)

// var binding
for { book <- books 
    bookval = book.toUpperCase()
} println(bookval)

// yield
val scalabooks = for { book <- books 
    if book.contains("Scala")} yield book
```

### array
```scala
var books: Array[String] = new Array(5)
var books = new Array[String](3)
var fruits = Array("apple", "orange", "grape")

println(fruits(0))
```

### list
```scala
val books: List[String] = List("Scala", "Groovy", "Java")

// using :: cons operator with tail Nil
val books = "Scala" :: ("Java" :: ("Groovy" :: Nil))
```

### tuple
```scala
val tuple = (1, false, "Scala")
val tuple2 ="title" -> "Beginning Scala"

println(tuple._3) // 3rd element, Scala

val (t1, t2, t3) = tuple // unpack tuple to t1,t2,t3
```

### call by name
```scala
def doit(p: => String): Unit = {

}
```
[call by name](https://docs.scala-lang.org/tour/by-name-parameters.html)


### Option, Some, None
[Option, Sone, None: Avoiding null](https://www.safaribooksonline.com/library/view/programming-scala/9780596801908/ch02s08.html)


### import
```scala
import akka.actor._
import java.util.{Map, HashMap}

// rename import
import java.math.BigInteger.{
    ONE, TEN, ZERO => JAVAZERO
}
```
