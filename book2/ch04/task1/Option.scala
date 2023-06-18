package option:

  sealed trait Option[+A]
  case class Some[+A](get: A) extends Option[A]
  case object None extends Option[Nothing]

  object Option:
    def map[A, B](option: Option[A])(f: A => B): Option[B] = option match
      case None    => None
      case Some(a) => Some(f(a))

    def printMapExamples(): Unit =
      val example: Option[Int] = map(Some(2))((x: Int) => x + 11)
      val example2: Option[Int] = map(None)((x: Int) => x + 11)
      println(s"\tmap(Some(2))((x: Int) => x + 11) = ${example}")
      println(s"\tmap(None)((x: Int) => x + 11) = ${example2}")

    // explanation of '[B >: A]'
    // https://docs.scala-lang.org/tour/lower-type-bounds.html
    // explanation of 'default: => B'
    // https://users.scala-lang.org/t/what-does-x-int-mean-in-scala/5558
    def getOrElse[A, B >: A](option: Option[A])(default: => B): B = option match
      case None    => default
      case Some(a) => a

    def printGetOrElseExamples(): Unit =
      val example: Int = getOrElse(Some(3))(4)
      val example2: Int = getOrElse(None)(5)
      println(s"\tgetOrElse(Some(3))(4) = ${example}")
      println(s"\tgetOrElse(None)(5) = ${example2}")

    def flatMap[A, B](option: Option[A])(f: A => Option[B]): Option[B] =
      option match
        case None    => None
        case Some(a) => f(a)

    // without match
    def flatMap2[A, B](option: Option[A])(f: A => Option[B]): Option[B] =
      getOrElse(map(option)(f))(None)

    def printFlatMapExamples(): Unit =
      println("\tflatMap written with match")
      val example: Option[Char] = flatMap(Some(2))((_: Int) => Some('c'))
      val example2: Option[Int] = flatMap(None)((x: Int) => Some(x + 11))
      println(s"\t\tflatMap(Some(2))((_: Int) => Some('c')) = ${example}")
      println(s"\t\tflatMap(None)((x: Int) => Some(x + 11)) = ${example2}")

      println("\tflatMap2 written without match")
      val example3: Option[Char] = flatMap2(Some(2))((_: Int) => Some('c'))
      val example4: Option[Int] = flatMap2(None)((x: Int) => Some(x + 11))
      println(s"\t\tflatMap2(Some(2))((_: Int) => Some('c')) = ${example3}")
      println(s"\t\tflatMap2(None)((x: Int) => Some(x + 11)) = ${example4}")

    def filter[A](option: Option[A])(f: A => Boolean): Option[A] = option match
      case None    => None
      case Some(a) => if (f(a)) Some(a) else None

    // without match
    def filter2[A](option: Option[A])(f: A => Boolean): Option[A] =
      if (getOrElse(map(option)(f))(false)) option else None

    def printFilterExamples(): Unit =
      println("\tFilter written with match")
      val example: Option[Int] = filter(Some(5))((x: Int) => x < 4)
      val example2: Option[Int] = filter(Some(3))((x: Int) => x < 4)
      val example3: Option[Int] = filter(None)((x: Int) => x < 4)
      println(s"\t\tfilter(Some(5))((x: Int) => x < 4) = ${example}")
      println(s"\t\tfilter(Some(3))((x: Int) => x < 4) = ${example2}")
      println(s"\t\tfilter(None)((x: Int) => x < 4) = ${example3}")

      println("\tFilter written without match")
      val example4: Option[Int] = filter2(Some(5))((x: Int) => x < 4)
      val example5: Option[Int] = filter2(Some(3))((x: Int) => x < 4)
      val example6: Option[Int] = filter2(None)((x: Int) => x < 4)
      println(s"\t\tfilter2(Some(5))((x: Int) => x < 4) = ${example4}")
      println(s"\t\tfilter2(Some(3))((x: Int) => x < 4) = ${example5}")
      println(s"\t\tfilter2(None)((x: Int) => x < 4) = ${example6}")
