package listing3_1

sealed trait List[+A]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def map[A, B](l: List[A])(f: A => B): List[B] = l match {
    case Nil         => Nil
    case Cons(x, xs) => Cons(f(x), map(xs)(f))
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1, 2, 3)

  def printMapExamples(): Unit = {
    val MapExample: List[Int] =
      map(Cons(1, Cons(2, Cons(3, Nil: List[Int]))))(x => x * 2)
    val MapExample2: List[Double] =
      map(Cons(2.2, Cons(3.4, Nil: List[Double])))((x: Double) => x / 2)
    val MapExample3: List[String] =
      map(Cons('a', Cons('b', Cons('c', Nil: List[Char]))))(x => s"zz${x}")
    val MapExample4: List[Int] = map(Nil: List[Int])(_ + 2)

    println("map(Cons(1, Cons(2, Cons(3, Nil:List[Int]))))(x => x*2)")
    println(s"Result: ${MapExample}\n")

    println(
      "map(Cons(2.2, Cons(3.4, Nil: List[Double])))((x: Double) => x / 2)"
    )
    println(s"Result: ${MapExample2}\n")

    println(
      "map(Cons('a', Cons('b', Cons('c', Nil: List[Char]))))(x => s\"zz${x}\")"
    )
    println(s"Result: ${MapExample3}\n")

    println("map(Nil: List[Int])(_ + 2)")
    println(s"Result: ${MapExample4}\n")
  }
}
