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

  // z in signature replaced with acc
  // acc stands for accumulator, so it is easier to reason about the foldLeft
  def foldLeft[A,B](l: List[A], acc: B)(f: (B, A) => B): B = l match {
    case Nil => acc
    case Cons(x, Nil) => f(acc, x)
    case Cons(x1, Cons(x2, xs)) => foldLeft(xs, f(f(acc, x1), x2))(f)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1, 2, 3)
  val total = sum(example)

  def printfoldLeftExamples(): Unit = {

    // checking the order of execution of foldLeft
    println("foldLeft(Cons(2, Cons(5, Cons(1, Nil))), 100)\n((acc, b) => {println(s\"${acc}/${b}\"); acc / b })")
    println("printing folding trace:")
    val foldLeftExample: Float = foldLeft(Cons(2, Cons(5, Cons(1, Nil))), 100)((acc, b) => {println(s"${acc}/${b}"); acc / b })
    println(s"Result: ${foldLeftExample}\n")

    val foldLeftExample2: Float = foldLeft(Cons(3, Cons(2, Nil)), 66)((acc, b) => acc / b)
    val foldLeftExample3: Float = foldLeft(Cons(3, Nil), 27)((acc, b) => acc / b)
    val foldLeftExample4: Float = foldLeft(Nil:List[Int], 27)((acc, b) => acc / b)

    println("foldLeft(Cons(3, Cons(2, Nil)), 66)((acc, b) => acc / b)")
    println(s"Result: ${foldLeftExample2}\n")

    println("foldLeft(Cons(3, Nil), 27)((acc, b) => acc / b)")
    println(s"Result: ${foldLeftExample3}\n")

    println("foldLeft(Nil:List[Int], 27)((acc, b) => acc / b)")
    println(s"Result: ${foldLeftExample4}\n")
  }
}
