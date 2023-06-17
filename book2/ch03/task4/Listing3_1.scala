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

    def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match
      case Nil             => Nil
      case Cons(x, xs) if f(x) => dropWhile(xs)(f)
      case _               => l

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))

    val example = Cons(1, Cons(2, Cons(3, Nil)))
    val example2 = List(1, 2, 3)
    val total = sum(example)

    def printDropWhileExamples(): Unit =
      val dropWhileExample = dropWhile(Cons(1, Cons(2, Cons(3, Nil))))((x: Int) => x < 3)
      val dropWhileExample2 = dropWhile(Cons(1, Cons(2, Cons(3, Nil))))((x: Int) => x < 2)
      val dropWhileExample3 = dropWhile(Cons(1, Cons(2, Cons(3, Nil))))((x: Int) => x > 10)
      val dropWhileExample4 = dropWhile(Cons(1, Cons(3, Cons(2, Nil))))((x: Int) => x < 2)
      val dropWhileExample5 = dropWhile(Nil)((x: Int) => x < 2)

      print("dropWhile(Cons(1, Cons(2, Cons(3, Nil))))((x: Int) => x < 3) \t = ")
      println(s"${dropWhileExample}")

      print("dropWhile(Cons(1, Cons(2, Cons(3, Nil))))((x: Int) => x < 2) \t = ")
      println(s"${dropWhileExample2}")

      print("dropWhile(Cons(1, Cons(2, Cons(3, Nil))))((x: Int) => x > 10) \t = ")
      println(s"${dropWhileExample3}")

      print("dropWhile(Cons(1, Cons(3, Cons(2, Nil))))((x: Int) => x < 2) \t = ")
      println(s"${dropWhileExample4}")

      print("dropWhile(Nil)((x: Int) => x < 2) \t = ")
      println(s"${dropWhileExample5}")
