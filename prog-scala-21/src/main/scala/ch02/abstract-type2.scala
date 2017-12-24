package ch02

/*
another implementation of abstract type
 */

import java.io._

object Main5 {
  def main(args: Array[String]): Unit = {
    println(new StringBulkReader("Hello Scala!").read)
  }
}

abstract class BulkReader[In] {
  val source: In
  def read: String
}

class StringBulkReader(val source: String)
  extends BulkReader[String] {
  def read = source
}

class FileBulkReader(val source: File)
  extends BulkReader[File] {
  def read = {
    val in = new BufferedInputStream(new FileInputStream(source))
    val size = in.available()
    val buffer = new Array[Byte](size)
    in.read(buffer, 0, size)

    new String(buffer)
  }
}