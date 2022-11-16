object Task7 {
  def myMap[A, B, E](e: Either[E, A])(f: A => B): Either[E, B] = e match {
    case Right(r1) => Right(f(r1))
    case Left(l1)  => Left(l1)
  }

  def myFlatMap[A, EE >: E, B, E](
      e: Either[EE, A]
  )(f: A => Either[EE, B]): Either[EE, B] = e match {
    case Right(r1) => f(r1)
    case Left(l1)  => Left(l1)
  }

  def add1IfPositive(num: Int): Either[String, Int] =
    if (num > 0) Right(num + 1) else Left("num not greater than 0")

  def myOrElse[EE >: E, B >: A, E, A](
      e: Either[E, A]
  )(b: => Either[EE, B]): Either[EE, B] = e match {
    case Left(_)   => b
    case Right(r1) => Right(r1)
  }

  def main(args: Array[String]): Unit = {
    println("\n" + "-" * 30)
    println("Task7.")

    println("\nmap with Either examples:")
    println(s"myMap(Right(5))((x: Int) => x + 6) = ${myMap(Right(5))((x: Int) => x + 6)}")
    println(s"myMap(Left(5))((x: Int) => x + 6) = ${myMap(Left(5))((x: Int) => x + 6)}")

    println("\nflatMap with Either examples:")
    println(s"myFlatMap(Right(5))(add1IfPositive) = ${myFlatMap(Right(5))(add1IfPositive)}")
    print(s"myFlatMap(Right(0))(add1IfPositive) = ${myFlatMap(Right(0))(add1IfPositive)}")
    println(",\nwhere:")
    println("def add1IfPositive(num: Int): Either[String, Int]")

    println("\norElse with Either examples:")
    println(s"myOrElse(Right(5))(Right(4)) = ${myOrElse(Right(5))(Right(4))}")
    println(s"myOrElse(Left(5))(Right(4)) = ${myOrElse(Left(5))(Right(4))}")

    println("\nThat's all. Goodbye!")
    println("-" * 30 + "\n")
  }
}
