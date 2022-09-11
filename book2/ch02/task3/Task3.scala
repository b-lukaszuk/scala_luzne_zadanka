object Task3 {
  private def partial1[A, B, C](a: A, f: (A, B) => C): B => C = {
    def partiallyAppliedFn(b: B): C = {
      f(a, b)
    }
    partiallyAppliedFn
  }

  // exemplary usage of partial1
  private def add1(b: Int): Int = {
    partial1(1, (x: Int, y: Int) => x + y)(b)
  }

  // another exemplary usage of partial1
  private val add2 = partial1(2, (x: Int, y: Int) => x + y)

  def main(args: Array[String]) = {
    println("\nHi. The program defines partially applied function.")
    println("Then it uses it in add1 and add2 function.")
    println("Let's test it out.\n")
    for (i <- 1 to 10) {
      println(s"add1(${i}) = ${add1(i)}")
      println(s"add2(${i}) = ${add2(i)}\n")
    }
    println("That's all. Goodbye!")
  }
}
