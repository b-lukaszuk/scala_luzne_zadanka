import scala.annotation.tailrec

@tailrec
def isPrime(num:Int, div:Int=2): Boolean =
  require(num > 1, "Number must be greater than 1.")
  if (div > math.sqrt(num)) then
    true
  else if (num % div == 0) then
    false
  else
    isPrime(num, div+1)

@main def task2: Unit =
  println()
  println("-" * 30)
  println("Recursive function `isPrime`. Examples.\n")

  println("\nTesting if numbers 2 to 100 are prime.")
  (2 to 12).foreach((n) =>
      println(s"isPrime($n) => ${isPrime(n)}")
      )

  println("\nPrinting prime numbers from 2 to 100.")
  (2 to 100).foreach((n) =>
      if(isPrime(n)) then
        println(n)
      else
        print("")
      )

  println("\nThat's all. Goodbye!")
  println("-" * 30)
  println()
