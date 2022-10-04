package tree

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  // a reminder/template
  // my solution for lists (Task 10, Listing3_1.scala)
  // def foldLeft[A, B](l: List[A], acc: B)(f: (B, A) => B): B = l match {
  //   case Nil                    => acc
  //   case Cons(x, Nil)           => f(acc, x)
  //   case Cons(x1, Cons(x2, xs)) => foldLeft(xs, f(f(acc, x1), x2))(f)
  // }

  // my previous solution to maximum
  // def maximum(ints: Tree[Int]): Int = ints match {
  //   case Leaf(x)             => x
  //   case Branch(left, right) => maximum(left).max(maximum(right))
  // }

  // my previous solution to depth
  // def depth[A](tree: Tree[A]): Int = tree match {
  //   case Leaf(_)             => 0
  //   case Branch(left, right) => (1 + depth(left)).max(1 + depth(right))
  // }

  // my previous solution to map
  // def map[A, B](tree: Tree[A])(fn: A => B): Tree[B] = tree match {
  //   case Leaf(x)             => Leaf(fn(x))
  //   case Branch(left, right) => Branch(map(left)(fn), map(right)(fn))
  // }

  def fold[A, B](tree: Tree[A])(fn: A => B)(accFn: (B, B) => B): B =
    tree match {
      case Leaf(x) => fn(x)
      case Branch(left, right) =>
        accFn(fold(left)(fn)(accFn), fold(right)(fn)(accFn))
    }

  // val example: Tree[Int] = map(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))(_ * 2)
  // val example2: Tree[Float] =
  //   map(Branch(Leaf(13), Branch(Leaf(2), Leaf(5))))(_.toFloat / 2)
  // val example3: Tree[Int] = map(
  //   Branch(Leaf('a'), Branch(Leaf('b'), Branch(Leaf('c'), Leaf('d'))))
  // )(_.toInt)

  def printFoldExamples(): Unit = {
    println("printFoldExamples")
  }
}
