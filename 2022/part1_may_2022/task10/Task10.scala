object Task10 {
  def main(args: Array[String]): Unit = {

    val nums: List[Int] = List(1, 2, 3, 4, 5, 6)

    def wrapRotations(kRot: Int, aList: List[Int] = nums): Int = {
      kRot % aList.size
    }

    def rotateByK(k: Int, aList: List[Int] = nums): List[Int] = {
      val adjustedK: Int = wrapRotations(k, aList)
      aList.drop(adjustedK) ++ aList.take(adjustedK)
    }

    println("-" * 50)
    println("Task 10")
    println(s"Rotating the list: [${nums.mkString(", ")}] by")
    Range(0, 14).foreach { i =>
      println(s"${i}: [${rotateByK(i, nums).mkString(", ")}]")
    }
    println("That's it goodbye!")
    println("-" * 50)
  }
}
