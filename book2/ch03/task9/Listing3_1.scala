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

  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = // Utility functions
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def length[A](l: List[A]): Int = {
    foldRight(l, 0: Int)((_: A, acc: Int) => acc + 1)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1, 2, 3)
  val total = sum(example)

  def printlengthExamples(): Unit = {
    val lengthExample = length(Cons(1, Cons(2, Cons(3, Nil))))
    val lengthExample2 = length(Cons(2, Cons(3, Nil)))
    val lengthExample3 = length(Cons(3, Nil))
    val lengthExample4 = length(Nil)

    println("length(Cons(1, Cons(2, Cons(3, Nil))))")
    println(s"Result: ${lengthExample}\n")

    println("length(Cons(2, Cons(3, Nil)))")
    println(s"Result: ${lengthExample2}\n")

    println("length(Cons(3, Nil))")
    println(s"Result: ${lengthExample3}\n")

    println("length(Nil)")
    println(s"Result: ${lengthExample4}\n")
  }
}
