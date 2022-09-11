object Task4 {

  private def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    def curriedFn1(a: A): B => C = {
      def curriedFn2(b: B): C = {
        f(a, b)
      }
      curriedFn2
    }
    curriedFn1
  }

  def main(args: Array[String]) = {
    println("\nHi. The program defines a curried function of 2 args.")
    println("Then it uses it on two integers.")
    println("Let's test it out.\n")

    println("The function invocation is: curry((x: Int, y: Int) => x+y)(1)(2)")
    println(s"The result is: ${curry((x: Int, y: Int) => x + y)(1)(2)}")

    println("The function invocation is: curry((x: Int, y: Int) => x-y)(12)(3)")
    println(s"The result is: ${curry((x: Int, y: Int) => x - y)(12)(3)}")

    println("\nThat's all. Goodbye!\n")
  }
}
