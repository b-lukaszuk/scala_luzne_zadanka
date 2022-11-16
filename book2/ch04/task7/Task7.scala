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

  def myMap2[EE >: E, B, C, A, E](
      a: Either[EE, A]
  )(b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = (a, b) match {
    case (Left(a2), _)          => Left(a2)
    case (_, Left(b2))          => Left(b2)
    case (Right(a1), Right(b1)) => Right(f(a1, b1))
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

    println("\nmap2 with Either examples:")
    println(s"myMap2(Right(2))(Right(3))((x: Int, y: Int) => x - y) = ${myMap2(
        Right(2)
      )(Right(3))((x: Int, y: Int) => x - y)}")
    println(s"myMap2(Left(2))(Right(3))((x: Int, y: Int) => x - y) = ${myMap2(
        Left(2)
      )(Right(3))((x: Int, y: Int) => x - y)}")
    println(s"myMap2(Right(2))(Left(3))((x: Int, y: Int) => x - y) = ${myMap2(
        Right(2)
      )(Left(3))((x: Int, y: Int) => x - y)}")

    println("\nThat's all. Goodbye!")
    println("-" * 30 + "\n")
  }
}
