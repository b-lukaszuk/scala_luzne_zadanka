import scala.util.Random

object Task4_4 {
  def main(args: Array[String]): Unit = {

    val nums1: Array[Int] = Array(1, 6, 23, 8, 4, 8, 3, 7)

    def getRandInt(minIncl: Int, maxExcl: Int): Int = {
      val rnd: Random = new Random
      val r1: Int = minIncl + rnd.nextInt(maxExcl - minIncl)
      r1
    }

    def getRandNumsFromArr(arr: Array[Int], howMany: Int): Array[Int] = {
      var result: Array[Int] = Array()
      for (i <- 1 to howMany) {
        result +:= arr(getRandInt(0, arr.length))
      }
      result
    }

    def getMin(arr: Array[Int]): Int = {
      arr.reduce((a, b) => a.min(b))
    }

    def declare(arr: Array[Int]): Unit = {
      println(s"\nGiven the array:")
      println(arr.mkString(", "))
      println("I draw at random 5 elements (with replacement):")
      val drawnNums: Array[Int] = getRandNumsFromArr(arr, 5)
      println(drawnNums.mkString(", "))
      println("The lowest drawn value is:")
      println(getMin(drawnNums))
    }

    println("-" * 50)
    println("Task 4.4")
    declare(nums1)
    println("That's it goodbye!")
    println("-" * 50)
  }
}
