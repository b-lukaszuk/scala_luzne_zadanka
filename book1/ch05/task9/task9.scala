// gcd = xa + by
// returns (gcd, x, y)
def getEEuclid(a: Int, b: Int): (Int, Int, Int) =
    if b == 0 then
       (a, 1, 0)
    else
        val (gcd, x, y) = getEEuclid(b, a % b)
        (gcd, y, x - math.floor(a/b).toInt * y)

@main def task9(): Unit =
  println()
  println("-" * 30)
  println("Recursive functions for eEuclid. Examples.\n")

  println(s"gcd = xa + by")
  println(s"getEEuclid(a, b) => (gcd, x, y)\n")

  println(s"getEEuclid(25, 10) = ${getEEuclid(25, 10)}, expected: (5, 1, -2)")
  println(s"getEEuclid(63, 57) = ${getEEuclid(63, 57)}, expected: (3, -9, 10)")
  println(s"getEEuclid(7, 9) = ${getEEuclid(7, 9)}, expected: (1, 4, -3)")

  println("\nThat's all. Goodbye!")
  println("-" * 30)
  println()
