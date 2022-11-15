object Task6 {
  def combine[B](b: Option[B], acc: Option[List[B]]): Option[List[B]] =
    (b, acc) match {
      case (None, _)              => None
      case (_, None)              => None
      case (Some(b1), Some(acc1)) => Some(b1 :: acc1)
    }

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
    case head :: tail => combine(f(head), traverse(tail)(f))
    case Nil          => Some(Nil)
  }

  def add1ToPositive(x: Int): Option[Int] = if (x > 0) Some(x + 1) else None

  def sequence[A](a: List[Option[A]]): Option[List[A]] = traverse(a)(identity)

  def main(args: Array[String]): Unit = {
    println("\n" + "-" * 30)
    println("Task6.")

    println("\n---Traverse examples---")
    println("Additional info:")
    println("def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]]")
    println("def add1ToPositive(x: Int): Option[Int] = if (x > 0) Some(x + 1) else None")
    println("Examples:")
    println(s"traverse(List(1, 2, 3))(add1ToPositive) = ${traverse(List(1, 2, 3))(add1ToPositive)}")
    println(s"traverse(List(1, -2, 3))(add1ToPositive) = ${traverse(List(1, -2, 3))(add1ToPositive)}")

    println("\n---Sequence (implemented with traverse) examples---")
    println("Additional info:")
    println("def sequence[A](a: List[Option[A]]): Option[List[A]] = traverse(a)(identity)")
    println("Examples:")
    println(s"sequence(List(Some(1), Some(2))) = ${sequence(List(Some(1), Some(2)))}")
    println(s"sequence(Nil) = ${sequence(Nil)}")
    println(s"sequence(List(Some(1), None, Some(2))) = ${sequence(List(Some(1), None, Some(2)))}")

    println("\nThat's all. Goodbye!")
    println("-" * 30 + "\n")
  }
}
