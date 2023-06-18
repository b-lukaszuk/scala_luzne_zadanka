object Task1:
  // exponent must be >= 0
  @scala.annotation.tailrec
  def myPower(base: Int, exponent: Int, acc: Double = 1): Double =
    exponent match
      case exponent if (exponent == 0) => acc
      case exponent if (exponent == 1) => acc * base
      case exponent if (exponent > 1) => myPower(base, exponent - 1, acc * base)
      case _ => throw new ArithmeticException("exponent must be >= 0")

  def myPow(base: Int, exponent: Int): Double = exponent match
    case exponent if (exponent < 0) => 1 / myPower(base, exponent * -1, 1)
    case _                          => myPower(base, exponent, 1)

  def main(args: Array[String]): Unit =
    println("\n" + "-" * 30)
    println("Task1.\n")
    println("'myPow(base: Int, exponent: Int): Double' examples:\n")
    println(s"myPow(2, -4) = ${myPow(2, -4)}")
    println(s"myPow(3, 0) = ${myPow(3, 0)}")
    println(s"myPow(3, 1) = ${myPow(3, 1)}")
    println(s"myPow(4, 3) = ${myPow(4, 3)}")
    println("\nThat's all. Goodbye!")
    println("-" * 30 + "\n")
