package listing3_1

sealed trait List[+A]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  // z in signature replaced with acc
  // acc stands for accumulator, so it is easier to reason about the foldLeft
  def foldLeft[A,B](l: List[A], acc: B)(f: (B, A) => B): B = l match {
    case Nil => acc
    case Cons(x, Nil) => f(acc, x)
    case Cons(x1, Cons(x2, xs)) => foldLeft(xs, f(f(acc, x1), x2))(f)
  }

  def sum(l: List[Int]): Int = {
    foldLeft(l, 0)(_ + _)
  }

  def product(l: List[Int]): Int = {
    foldLeft(l, 1)(_ * _)
  }

  def length(l: List[Int]): Int = {
    foldLeft(l, 0)((acc: Int, _: Int) => acc + 1)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1, 2, 3)
  val total = sum(example)

  def printfoldLeftExamples(): Unit = {
    val foldLeftExample: Float = sum(Cons(1, Cons(2, Cons(3, Nil:List[Int]))))
    val foldLeftExample2: Float = product(Cons(2, Cons(2, Cons(3, Nil:List[Int]))))
    val foldLeftExample3: Float = length(Cons(2, Cons(2, Cons(3, Nil:List[Int]))))
    val foldLeftExample4: Float = length(Nil)


    println("sum(Cons(1, Cons(2, Cons(3, Nil:List[Int]))))")
    println(s"Result: ${foldLeftExample}\n")

    println("product(Cons(2, Cons(2, Cons(3, Nil:List[Int]))))")
    println(s"Result: ${foldLeftExample2}\n")

    println("length(Cons(2, Cons(2, Cons(3, Nil:List[Int]))))")
    println(s"Result: ${foldLeftExample3}\n")

    println("length(Nil)")
    println(s"Result: ${foldLeftExample4}\n")
  }
}
