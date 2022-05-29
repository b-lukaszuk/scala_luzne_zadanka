import scala.util.matching.Regex

class DigitGetter {

  val numPattern: Regex = "[0-9]".r

  def getDigits(num: Int): Array[Int] = {
    numPattern.findAllIn(num.toString).map(i => i.toInt).toArray
  }

  def getDigits(text: String): Array[Int] = {
    numPattern.findAllIn(text).map(i => i.toInt).toArray
  }
}

object Task12 {
  def main(args: Array[String]): Unit = {

    val toTest1: Int = 2342
    val toTest2: String = "A243b"
    val toTest3: String = "Alan"

    val dg: DigitGetter = new DigitGetter()

    def declare(toTest: Any, result: Array[Int]): Unit = {
      print(s"testing >>${toTest}<< for digits, result: ")
      println(s"[${result.mkString(", ")}]")
    }

    def testAndDeclare(o: Any): Unit = o match {
      case (o: Int)    => declare(o, dg.getDigits(o))
      case (o: String) => declare(o, dg.getDigits(o))
      case _           => println("function argument must be Int or String")
    }

    println("-" * 30)
    println("Task 12")
    testAndDeclare(toTest1)
    testAndDeclare(toTest2)
    testAndDeclare(toTest3)
    println("-" * 30)
  }
}
