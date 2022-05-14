object Task2_1 {
  def main(args: Array[String]) = {

    val years: Array[Int] = Array(1974, 1900, 1985, 2000);

    // https://en.wikipedia.org/wiki/Leap_year#Algorithm
    def isLeap(year: Int): Boolean = year match {
      case year if (year % 4 != 0)  => false
      case year if (year % 25 != 0) => true
      case year if (year % 16 != 0) => false
      case _                        => true
    }

    println("-" * 50)
    println("Task 2.1")
    println("Out of the years:")
    println(years.mkString(", "))
    println("the following are leap years:")
    println(years.filter(y => isLeap(y)).mkString(", "))
    println("That's it goodbye!")
    println("-" * 50)
  }
}
