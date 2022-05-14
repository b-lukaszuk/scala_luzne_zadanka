object Task2_6 {
  def main(args: Array[String]) = {

    val nums: Array[Double] = Array(1, 6, 23, 8, 4, 98, 3, 7, 3, 98, 4, 98)

    def getAvgOfEvens(someNums: Array[Double]): Double = {
      if (someNums.length == 0) {
        throw new ArithmeticException("Empty list got no average")
      } else {
        val evens: Array[Double] = someNums.filter(_ % 2 == 0)
        if (evens.length == 0) {
          throw new ArithmeticException("No evens => No average")
        }
        evens.sum / evens.length
      }
    }

    println("-" * 50)
    println("Task 2.6")
    println("Given the numbers:")
    println(nums.mkString(", "))
    println("The average of even numbers is:")
    println(getAvgOfEvens(nums).toString())
    println("That's it goodbye!")
    println("-" * 50)
  }
}
