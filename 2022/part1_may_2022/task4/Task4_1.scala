object Task4_1 {
  def main(args: Array[String]): Unit = {

    val nums1: Array[Int] = Array(1, 6, 23, 8, 4, 8, 3, 7)
    val nums2: Array[Int] = Array(1, 6, 23, 8, 4, 8, 3, 7, 9)

    def addAccordToPattern(arr: Array[Int]): Array[Int] = {
      var result: Array[Int] = Array();
      Range(0, arr.length, 2).foreach { i =>
        result :+= arr(i) + {
          if (i + 1 >= arr.length) 0 else arr(i + 1)
        }
      }
      result
    }

    def declare(arr: Array[Int], arrName: String): Unit = {
      println(s"\nGiven the array ${arrName}:")
      println(arr.mkString(", "))
      println("summing its elements according to the pattern:")
      println("[a+b, c+d, e+f, ...]")
      println("gives:")
      println(addAccordToPattern(arr).mkString(", ") + "\n")
    }

    println("-" * 50)
    println("Task 4.1")
    declare(nums1, "nums1")
    declare(nums2, "nums2")
    println("That's it goodbye!")
    println("-" * 50)
  }
}
