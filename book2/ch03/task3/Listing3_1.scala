package listing3_1

sealed trait List[+A]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def sum(ints: List[Int]): Int = ints match {
    case Nil         => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil          => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs)  => x * product(xs)
  }

  def drop[A](l: List[A], n: Int): List[A] = {
    if (n <= 0) l
    else
      l match {
        case Nil         => Nil
        case Cons(_, xs) => drop(xs, n - 1)
      }
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1, 2, 3)
  val total = sum(example)

  def printDropExamples(): Unit = {
    val dropExample = drop(Cons(1, Cons(2, Cons(3, Nil))), -3)
    val dropExample2 = drop(Cons(1, Cons(2, Cons(3, Nil))), 2)
    val dropExample3 = drop(Cons(1, Cons(2, Cons(3, Nil))), 10)
    val dropExample4 = drop(Nil, 2)

    println(s"drop(Cons(1, Cons(2, Cons(3, Nil))), -3) \t = \t ${dropExample}")

    println(s"drop(Cons(1, Cons(2, Cons(3, Nil))), 2) \t = \t ${dropExample2}")

    println(s"drop(Cons(1, Cons(2, Cons(3, Nil))), 10) \t = \t ${dropExample3}")

    println(s"drop(Nil, 2) \t = \t ${dropExample4}")
  }
}
