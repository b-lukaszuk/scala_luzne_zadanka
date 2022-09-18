package listing3_1

sealed trait List[+A]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  // name inspired by Haskell
  def zipWith[A, B, C](l1: List[A], l2: List[B])(fn: (A, B) => C): List[C] =
    (l1, l2) match {
      case (Nil, _)                   => Nil
      case (_, Nil)                   => Nil
      case (Cons(x, xs), Cons(y, ys)) => Cons(fn(x, y), zipWith(xs, ys)(fn))
    }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1, 2, 3)

  def printZipWithExamples(): Unit = {
    val zipWithExample: List[Int] =
      zipWith(Cons(1, Cons(2, Nil)), Cons(2, Cons(3, Nil)))(_ + _)

    val zipWithExample2: List[String] =
      zipWith(Cons('a', Cons('b', Nil)), Cons('y', Cons('z', Nil)))(
        (j: Char, k: Char) => s"${j} and ${k}"
      )

    val zipWithExample3: List[String] =
      zipWith(Cons('a', Cons('b', Nil)), Cons('y', Nil))((j: Char, k: Char) =>
        s"${j} and ${k}"
      )

    println(
      "zipWith(Cons(1, Cons(2, Nil)), Cons(2, Cons(3, Nil)))(_ + _)"
    )
    println(s"Result: ${zipWithExample}\n")

    println(
      "zipWith(Cons('a', Cons('b', Nil)), Cons('y', Cons('z', Nil)))(\n(j: Char, k: Char) => s\"${j} and ${k}\"\n)"
    )
    println(s"Result: ${zipWithExample2}\n")

    println(
      "zipWith(Cons('a', Cons('b', Nil)), Cons('y', Nil))((j: Char, k: Char) =>\ns\"${j} and ${k}\n\")"
    )
    println(s"Result: ${zipWithExample3}\n")
  }
}
