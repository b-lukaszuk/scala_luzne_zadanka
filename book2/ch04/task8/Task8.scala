object Task8 {

  // definition from Task5.scala; to be modified
  def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
    case head :: tail =>
      head.flatMap((elt: A) =>
        sequence(tail).map((aList: List[A]) => elt :: aList)
      )
    case Nil => Some(Nil)
  }

  // definition from Task6.scala; to be modified
  def combine[B](b: Option[B], acc: Option[List[B]]): Option[List[B]] =
    (b, acc) match {
      case (None, _)              => None
      case (_, None)              => None
      case (Some(b1), Some(acc1)) => Some(b1 :: acc1)
    }

  // definition from Task6.scala; to be modified
  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
    case head :: tail => combine(f(head), traverse(tail)(f))
    case Nil          => Some(Nil)
  }

  // main with examples from Task5.scala; to be modified
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
