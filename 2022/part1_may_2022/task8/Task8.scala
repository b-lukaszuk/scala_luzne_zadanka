object Task8 {
  def main(args: Array[String]): Unit = {

    val max: Int = 101

    // uses so called Sieve of Eratosthenes
    def printPrimes(upToIncl: Int): Unit = {
      var isPrime: Array[Boolean] = Array.fill[Boolean](upToIncl + 1)(true)
      var cur: Int = 2 //   prime > 1
      while (cur * cur <= upToIncl) {
        if (isPrime(cur)) {
          for (i <- (cur * 2) to (upToIncl - 1) by cur) {
            isPrime(i) = false
          }
        }
        cur += 1
      }
      for (i <- 2 to upToIncl) {
        if (isPrime(i) && i != upToIncl) {
          print(i + ", ")
        }
        if (isPrime(i) && i == upToIncl) {
          println(i)
        }
      }
    }

    println("-" * 50)
    println("Task 8")
    println("Based on the Sieve of Eratosthenes")
    println(s"prime numbers up to ${max} are:")
    printPrimes(max)
    println("That's it. Goodbye!")
    println("-" * 50)
  }
}
