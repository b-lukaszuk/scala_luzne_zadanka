object Task2_1 {
  def main(args: Array[String]) = {

    val years: Array[Int] = Array(1974, 1900, 1985, 2000);

    // https://en.wikipedia.org/wiki/Leap_year#Algorithm
    def isLeap(year: Int): Boolean = {
      if (year % 4 != 0) {
        false
      } else if (year % 25 != 0) {
        true
      } else if (year % 16 != 0) {
        false
      } else {
        true
      }
    }

    println("-" * 50)
    println("Task 2.1")
    println("Out of the years:")
    years.foreach { y => print(y.toString() + " ") }
    println("\nthe following are leap years:")
    years.filter(y => isLeap(y)).foreach { y => print(y.toString() + " ") }
    println("\nThat's it goodbye!")
    println("-" * 50)
  }
}
