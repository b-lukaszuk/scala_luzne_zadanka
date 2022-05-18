import scala.util.Random

object Task4_6 {
  def main(args: Array[String]): Unit = {

    val nums1: Array[Int] = Array(1, 6, 23, 8, 4, 8, 3, 7)

    def getRandInt(minIncl: Int, maxExcl: Int): Int = {
      val rnd: Random = new Random
      val r1: Int = minIncl + rnd.nextInt(maxExcl - minIncl)
      r1
    }

    def addOrSubtrElts(arr: Array[Int]): Unit = {
      var result: Int = 0
      for (i <- 0 to arr.length - 1) {
        if (getRandInt(0, 2) == 0) {
          println(s"${result} - ${arr(i)} = ${result - arr(i)}")
          result -= arr(i)
        } else {
          println(s"${result} + ${arr(i)} = ${result + arr(i)}")
          result += arr(i)
        }
      }
    }

    def declare(arr: Array[Int]): Unit = {
      println(s"\nGiven the array:")
      println(arr.mkString(", "))
      print("I go from left to right and randomly ")
      println("add or subtract its elements form total (at first = 0):")
      println("And so I get:")
      addOrSubtrElts(nums1)
    }

    println("-" * 50)
    println("Task 4.6")
    declare(nums1)
    println("\nThat's it goodbye!")
    println("-" * 50)
  }
}
