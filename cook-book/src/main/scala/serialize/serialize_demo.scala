import java.io._

@SerialVersionUID(100L)
class Stock(symbol: String, price: BigDecimal)
  extends Serializable {
  override def toString() = f"$symbol%s is ${price.toDouble}%.2f"
}

object SerializationDemo extends App {

  val nflx = new Stock("NFLX", BigDecimal(85.00))

  val oos = new ObjectOutputStream(new FileOutputStream("/tmp/nflx"))
  oos.writeObject(nflx)
  oos.close()

  val ois = new ObjectInputStream(new FileInputStream("/tmp/nflx"))
  val rstock = ois.readObject.asInstanceOf[Stock]
  ois.close()

  println(rstock)
}
