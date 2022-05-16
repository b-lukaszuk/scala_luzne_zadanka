object Task1 {
  def main(args: Array[String]): Unit = {
    def fact1(n: Int): Int = {
      @scala.annotation.tailrec
      def fact2(acc: Int, n: Int): Int = {
        if (n < 0) {
          throw new ArithmeticException("n must be >= 0")
        } else if (n == 0) {
          acc
        } else {
          fact2(acc * n, n - 1)
        }
      }
      fact2(1, n)
    }

    println("-" * 50)
    Range(0, 12).foreach { i => println(s"factorial(${i}) = ${fact1(i)}") }
    println("-" * 50)
  }
}
