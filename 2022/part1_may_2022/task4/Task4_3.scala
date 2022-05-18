import scala.util.Random

object Task4_3 {
  def main(args: Array[String]): Unit = {

    val nums1: Array[Int] = Array(1, 6, 23, 8, 4, 8, 3, 7)

    def getRandInt(minIncl: Int, maxExcl: Int): Int = {
      val rnd: Random = new Random
      val r1: Int = minIncl + rnd.nextInt(maxExcl - minIncl)
      r1
    }

    def declare(arr: Array[Int]): Unit = {
      println(s"\nGiven the array:")
      println(arr.mkString(", "))
      println("I draw a random element:")
      println(arr(getRandInt(0, arr.length)))
    }

    println("-" * 50)
    println("Task 4.3")
    declare(nums1)
    println("That's it goodbye!")
    println("-" * 50)
  }
}
