import scala.util.Random

object Task4_5 {
  def main(args: Array[String]): Unit = {

    val nums1: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)

    def getRandInt(minIncl: Int, maxExcl: Int): Int = {
      val rnd: Random = new Random
      val r1: Int = minIncl + rnd.nextInt(maxExcl - minIncl)
      r1
    }

    // not sure what is the built-in remove function
    // to play with Scala I created my own (Haskell like)
    def dropElt(arr: Array[Int], arrInd: Int): Array[Int] = {
      arr.take(arrInd) ++ arr.drop(arrInd + 1)
    }

    // task says specifically to remove elts from one array and put it to other
    def shuffle(arr: Array[Int]): Array[Int] = {
      var cpArr: Array[Int] = arr.map(identity)
      var result: Array[Int] = Array()
      var rndIndex: Int = 0;
      for (i <- 1 to cpArr.length) {
        rndIndex = getRandInt(0, cpArr.length)
        result +:= cpArr(rndIndex)
        cpArr = dropElt(cpArr, rndIndex)
      }
      result
    }

    def declare(arr: Array[Int]): Unit = {
      println(s"\nGiven the array:")
      println(arr.mkString(", "))
      println("I shuffle its elements and get:")
      println(shuffle(nums1).mkString(", "))
    }

    println("-" * 50)
    println("Task 4.5")
    declare(nums1)
    println("That's it goodbye!")
    println("-" * 50)
  }
}
