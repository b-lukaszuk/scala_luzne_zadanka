object Task1 {
  // nth should be >= 0
  def fibonnaci(nth: Int): Int = {
    // nth should be >= 0
    // https://en.wikipedia.org/wiki/Fibonacci_number#Definition
    @annotation.tailrec
    def fib(nth: Int, end: Int, acc: (Int, Int)): Int = {
      if (nth == end) {
        acc._1
      } else {
        fib(nth + 1, end, (acc._2, acc._1 + acc._2))
      }
    }

    // protection agains nth < 0 (returns input instead of error)
    if (nth < 0) {
      nth
    } else {
      fib(0, nth, (0, 1))
    }
  }

  def main(args: Array[String]) = {
    println("\nHi. This program prints fibonnaci numbers.")
    println("It calculates them using tail recursion.")
    println("Let's test it out.\n")
    for (i <- 0 to 20) println(s"fib(${i}) = ${fibonnaci(i)}")
    println("\nThat's all. Goodbye!\n")
  }
}
