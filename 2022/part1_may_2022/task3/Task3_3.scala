object Task3_3 {
  def main(args: Array[String]): Unit = {

    val nums: Array[Int] = Array(1, 6, 23, 8, 4, 8, 3, 7)

    def revArray1(someNums: Array[Int]): Array[Int] = {
      @scala.annotation.tailrec
      def revArrayHelper(acc: Array[Int], someArr: Array[Int]): Array[Int] =
        someArr match {
          case someArr if (someArr.length == 0) => acc
          case _ => revArrayHelper(someArr.head +: acc, someArr.tail)
        }
      revArrayHelper(Array(), someNums)
    }

    // like in Haskell
    def revArray2(someNums: Array[Int]): Array[Int] = {
      someNums.foldLeft(Array[Int]())((acc, b) => b +: acc)
    }

    def revArray3(someNums: Array[Int]): Array[Int] = {
      var newArr: Array[Int] = Array()
      someNums.foreach(i => newArr +:= i)
      newArr
    }

    // like in Haskell
    def revArray4(someNums: Seq[Int]): Seq[Int] = someNums match {
      case Seq()           => Seq()
      case Seq(x, xs @ _*) => revArray4(xs) :+ x
    }

    println("-" * 50)
    println("Task 3.3")
    println("Reversing the array:")
    println(nums.mkString(", "))
    println("we get")
    println(s"revArray1 = ${revArray1(nums).mkString(", ")}")
    println(s"revArray2 = ${revArray2(nums).mkString(", ")}")
    println(s"revArray3 = ${revArray3(nums).mkString(", ")}")
    println(s"revArray4 = ${revArray4(nums).mkString(", ")}")
    println("That's it goodbye!")
    println("-" * 50)
  }
}
