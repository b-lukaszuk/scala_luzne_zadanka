package listing3_1:

  sealed trait List[+A]
  case object Nil extends List[Nothing]
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List:
    def filter[A](l: List[A])(fn: A => Boolean): List[A] = l match
      case Nil                    => Nil
      case Cons(x, xs) if (fn(x)) => Cons(x, filter(xs)(fn))
      case Cons(_, xs)            => filter(xs)(fn)

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))

    val example = Cons(1, Cons(2, Cons(3, Nil)))
    val example2 = List(1, 2, 3)

    def printFilterExamples(): Unit =
      val filterExample: List[Int] =
        filter(Cons(1, Cons(2, Cons(3, Cons(4, Nil: List[Int])))))(x => x < 3)

      val filterExample2: List[Int] =
        filter(Cons(1, Cons(2, Cons(3, Cons(4, Nil: List[Int])))))(x => x > 2)

      val filterExample3: List[Int] =
        filter(Cons(1, Cons(2, Cons(3, Cons(4, Nil: List[Int])))))(x =>
          x % 2 == 0
        )

      println(
        "filter(Cons(1, Cons(2, Cons(3, Cons(4, Nil: List[Int])))))(x => x < 3)"
      )
      println(s"Result: ${filterExample}\n")

      println(
        "filter(Cons(1, Cons(2, Cons(3, Cons(4, Nil: List[Int])))))(x => x > 2)"
      )
      println(s"Result: ${filterExample2}\n")

      println(
        "filter(Cons(1, Cons(2, Cons(3, Cons(4, Nil: List[Int])))))(x => x % 2 == 0)"
      )
      println(s"Result: ${filterExample3}\n")
