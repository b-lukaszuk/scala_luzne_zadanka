object Task5:
  private def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    def curriedFn1(a: A): B => C =
      def curriedFn2(b: B): C =
        f(a, b)
      curriedFn2
    curriedFn1

  private def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    def uncarriedFn(a: A, b: B): C =
      f(a)(b)
    uncarriedFn

  def main(args: Array[String]) =
    println("\nHi. The program defines uncurry function")
    println("Then it uses it with a curried function as an argument")
    println("The fn 'curry' was defined in task4 (here copy-paste)")
    println("Let's test it out.\n")

    val add2Nums = curry((x: Int, y: Int) => x + y)
    val subtractYfromX = curry((x: Int, y: Int) => x - y)

    println("I got previously defined curried function add2Nums")
    println("val add2Nums = curry((x: Int, y: Int) => x + y)")
    println("I will use it after uncurrying")
    println(s"uncurry(add2Nums)(2, 3) = ${uncurry(add2Nums)(2, 3)}\n")

    println("I got previously defined curried function subtractYfromX")
    println("val subtractYfromX = curry((x: Int, y: Int) => x - y)")
    println("I will use it after uncurrying")
    println(s"uncurry(subtractYfromX)(21, 7) = ${uncurry(subtractYfromX)(21, 7)}")

    println("\nThat's all. Goodbye!\n")
