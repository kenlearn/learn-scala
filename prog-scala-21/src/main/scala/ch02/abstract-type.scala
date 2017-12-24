package ch02

import java.io._

object Main4 {
  def main(args: Array[String]): Unit = {
    println(new StringBulkReader("Hello Scala!").read)

    // println(new FileBulkReader(new File("abstract-type.scala")).read)
  }
}

abstract class BulkReader {
  type In
  val source: In
  def read: String
}

class StringBulkReader(val source: String)
  extends BulkReader {
  type In = String
  def read = source
}

class FileBulkReader(val source: File)
  extends BulkReader {
  type In = File
  def read = {
    val in = new BufferedInputStream(new FileInputStream(source))
    val nBytes = in.available()
    val bytes = new Array[Byte](nBytes)
    in.read(bytes, 0, nBytes)

    new String(bytes)
  }
}
