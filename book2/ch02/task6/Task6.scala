object Task6:
  private def myCompose[A, B, C](f: B => C, g: A => B): A => C =
    def composedFn(a: A): C =
      f(g(a))
    composedFn

  def main(args: Array[String]) =
    println("\nHi. The program defines compose function.")
    println("def myCompose[A, B, C](f: B => C, g: A => B): A => C")
    println("Then it uses it.")
    println("Let's test it out.\n")

    println("myCompose((x: Int) => x * 2, (y: Int) => y + 1)(3)")
    print("result: ")
    println(s"${myCompose((x: Int) => x * 2, (y: Int) => y + 1)(3)}\n")

    println("myCompose((x: Int) => x - 2, (y: Int) => y - 1)(7)")
    print("result: ")
    println(s"${myCompose((x: Int) => x - 2, (y: Int) => y - 1)(7)}")

    println("\nThat's all. Goodbye!\n")
