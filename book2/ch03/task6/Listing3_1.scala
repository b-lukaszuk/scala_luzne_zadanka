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

    def init[A](l: List[A]): List[A] = l match
      case Nil => Nil
      case Cons(_, Nil) => Nil
      case Cons(x, xs) => Cons(x, init(xs))

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))

    val example = Cons(1, Cons(2, Cons(3, Nil)))
    val example2 = List(1, 2, 3)
    val total = sum(example)

    def printInitExamples(): Unit =
      val initExample = init(Cons(1, Cons(2, Cons(3, Nil))))
      val initExample2 = init(Cons(2, Cons(3, Nil)))
      val initExample3 = init(Cons(3, Nil))
      val initExample4 = init(Nil)

      println("init(Cons(1, Cons(2, Cons(3, Nil))))")
      println(s"Result: ${initExample}\n")

      println("init(Cons(2, Cons(3, Nil)))")
      println(s"Result: ${initExample2}\n")

      println("init(Cons(3, Nil))")
      println(s"Result: ${initExample3}\n")

      println("init(Nil)")
      println(s"Result: ${initExample4}\n")
