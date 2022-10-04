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

  // size counts number of nodes (Branch or Leaf) in a tree
  def size[A](tree: Tree[A]): Int = {
    fold(tree)(_ => 1)(_ + _ + 1)
  }

  val example: Int = size(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))
  val example2: Int = size(Branch(Leaf('a'), Branch(Leaf('b'), Leaf('c'))))
  val example3: Int = size(
    Branch(Branch(Leaf('a'), Leaf('a')), Branch(Leaf('b'), Leaf('c')))
  )

  def printSizeExamples(): Unit = {
    println("size(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))")
    println(s"Result = ${example}")

    println("size(Branch(Leaf('a'), Branch(Leaf('b'), Leaf('c'))))")
    println(s"Result = ${example2}")

    println(
      "size(Branch(Branch(Leaf('a'), Leaf('a')), Branch(Leaf('b'), Leaf('c'))))"
    )
    println(s"Result = ${example3}")
  }
}
