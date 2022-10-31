import java.util.regex._

object Task5 {

  def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
    case head :: tail =>
      head.flatMap((elt: A) =>
        sequence(tail).map((aList: List[A]) => elt :: aList)
      )
    case Nil => Some(Nil)
  }

  def main(args: Array[String]): Unit = {

    val example: Option[List[Int]] = sequence(List(Some(1), Some(2)))
    val example2: Option[List[Int]] = sequence(Nil)
    val example3: Option[List[Int]] = sequence(List(Some(1), None, Some(2)))

    println("\n" + "-" * 30)
    println("Task5.")
    println("Sequence examples.\n")

    println("sequence(List(Some(1), Some(2)))")
    println(s"Result: ${example}\n")

    println("sequence(Nil)")
    println(s"Result: ${example2}\n")

    println("sequence(List(Some(1), None, Some(2)))")
    println(s"Result: ${example3}\n")

    println("That's all. Goodbye!")
    println("-" * 30 + "\n")
  }
}
