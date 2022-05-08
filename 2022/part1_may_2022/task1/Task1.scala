object Task1 {
  def main(args: Array[String]) = {
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

    val nums: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

    println("-" * 50)
    nums.foreach { i => println(s"factorial(${i}) = ${fact1(i)}") }
    println("-" * 50)
  }
}
