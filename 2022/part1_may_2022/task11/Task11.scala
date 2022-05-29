import scala.collection.mutable.HashMap

object Task11 {
  def main(args: Array[String]): Unit = {

    var fibNums: HashMap[Int, Int] = HashMap(0 -> 0, 1 -> 1)

    def getFib(n: Int): Int = n match {
      case n if (n < 0) => throw new ArithmeticException("n must be >= 0")
      case _ => fibNums.getOrElseUpdate(n, getFib(n - 1) + getFib(n - 2))
    }

    println("-" * 50)
    println("Task 11")
    List(0, 1, 4, 8, 10, 12, 15, 18, 20).foreach(i =>
      println(s"fib(${i}) = ${getFib(i)}")
    )
    println("That's it goodbye!")
    println("-" * 50)
  }
}
