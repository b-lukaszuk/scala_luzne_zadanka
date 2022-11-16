object Task7 {
  def myMap[A, B, E](e: Either[E, A])(f: A => B): Either[E, B] = e match {
    case Right(r1) => Right(f(r1))
    case Left(l1)  => Left(l1)
  }

  def main(args: Array[String]): Unit = {
    println("\n" + "-" * 30)
    println("Task7.\n")

    println("map with Either examples.")
    println("def myMap[A, B, E](e: Either[E, A])(f: A => B): Either[E, B]")
    println(s"myMap(Right(5))((x: Int) => x + 6) = ${myMap(Right(5))((x: Int) => x + 6)}")
    println(s"myMap(Left(5))((x: Int) => x + 6) = ${myMap(Left(5))((x: Int) => x + 6)}")

    println("\nThat's all. Goodbye!")
    println("-" * 30 + "\n")
  }
}
