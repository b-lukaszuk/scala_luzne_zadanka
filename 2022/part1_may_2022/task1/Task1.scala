object Task1 {
  def main(args: Array[String]): Unit = {
    def fact1(n: Int): Int = {
      @scala.annotation.tailrec
      def factHelper(acc: Int, n: Int): Int = {
        if (n < 0) {
          throw new ArithmeticException("n must be >= 0")
        } else if (n == 0) {
          acc
        } else {
          factHelper(acc * n, n - 1)
        }
      }
      factHelper(1, n)
    }

    def fact2(n: Int): Int = n match {
      case n if (n < 0)  => throw new ArithmeticException("n must be >= 0")
      case n if (n == 0) => 1
      case _             => Range(1, n + 1).reduce((a, b) => a * b)
    }

    println("-" * 50)
    Range(0, 12).foreach { i => println(s"fact1(${i}) = ${fact1(i)}") }
    println("-" * 50)
    Range(0, 12).foreach { i => println(s"fact2(${i}) = ${fact2(i)}") }
    println("-" * 50)
  }
}
