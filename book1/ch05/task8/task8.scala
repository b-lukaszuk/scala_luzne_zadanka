import scala.annotation.tailrec

@tailrec
def getGcd(a: Int, b: Int): Int =
    require(a >= 0 && b >= 0, "a and b must be positive")
    if b == 0 then
       a
    else
       getGcd(b, a % b)

def testGcd(gcd: (x: Int, y: Int) => Int): Unit =
    val rnd = new scala.util.Random
    val n1: Int = rnd.between(2, 30)
    val n2: Int = rnd.between(2, 30)
    println(s"getGcd($n1, $n2) = ${gcd(n1, n2)}")

@main def task8: Unit =
  println()
  println("-" * 30)
  println("Recursive functions for greatest common divisor. Examples.\n")

  for (_ <- 1 to 5)
      testGcd(getGcd)

  println("\nThat's all. Goodbye!")
  println("-" * 30)
  println()
