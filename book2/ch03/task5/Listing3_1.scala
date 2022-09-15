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

  def setHead[A](l: List[A], elt: A): List[A] = l match {
    case Nil => Nil
    case Cons(_, xs) => Cons(elt, xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1, 2, 3)
  val total = sum(example)

  def printSetHeadExamples(): Unit = {
    val setHeadExample = setHead(Cons(1, Cons(2, Cons(3, Nil))), 7)
    val setHeadExample2 = setHead(Cons(3, Nil), 7)
    val setHeadExample3 = setHead(Nil, 7)

    println("setHead(Cons(1, Cons(2, Cons(3, Nil))), 7)")
    println(s"Result: ${setHeadExample}\n")

    println("setHead(Cons(3, Nil), 7) ")
    println(s"Result: ${setHeadExample2}\n")

    println("setHead(Nil, 7)")
    println(s"Result: ${setHeadExample3}\n")
  }
}
