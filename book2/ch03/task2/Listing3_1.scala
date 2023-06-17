package listing3_1:

  sealed trait List[+A]
  case object Nil extends List[Nothing]
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List:
    def sum(ints: List[Int]): Int = ints match
      case Nil         => 0
      case Cons(x, xs) => x + sum(xs)

    def product(ds: List[Double]): Double = ds match
      case Nil          => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs)  => x * product(xs)

    def tail[A](someList: List[A]): List[A] = someList match
      case Nil => Nil
      case Cons(_, xs) => xs

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))

    val example = Cons(1, Cons(2, Cons(3, Nil)))
    val example2 = List(1, 2, 3)
    val total = sum(example)

    def printTailExamples(): Unit =
      val tailExample = tail(Cons(1, Cons(2, Cons(3, Nil))))
      val tailExample2 = tail(Nil)
      val tailExample3 = tail(Cons(3, Nil))
      val tailExample4 = tail(Cons(2, Cons(3, Nil)))

      println(s"tail(Cons(1, Cons(2, Cons(3, Nil)))) \t = \t${tailExample}")
      println(s"tail(Nil) \t = \t${tailExample2}")
      println(s"tail(Cons(3, Nil)) \t = \t${tailExample3}")
      println(s"tail(Cons(2, Cons(3, Nil))) \t = \t${tailExample4}")
