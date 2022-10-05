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

  def printSizeExamples(): Unit = {

    val example: Int = size(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))
    println("size(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))")
    println(s"Result = ${example}")

    val example2: Int = size(Branch(Leaf('a'), Branch(Leaf('b'), Leaf('c'))))
    println("size(Branch(Leaf('a'), Branch(Leaf('b'), Leaf('c'))))")
    println(s"Result = ${example2}")

    val example3: Int = size(
      Branch(Branch(Leaf('a'), Leaf('a')), Branch(Leaf('b'), Leaf('c')))
    )
    println(
      "size(Branch(Branch(Leaf('a'), Leaf('a')), Branch(Leaf('b'), Leaf('c'))))"
    )
    println(s"Result = ${example3}")
  }

  def maximum(tree: Tree[Int]): Int = {
    fold(tree)((a: Int) => a)((a: Int, b: Int) => a.max(b))
  }

  def maximum(tree: Tree[Double]): Double = {
    fold(tree)((a: Double) => a)((a: Double, b: Double) => a.max(b))
  }

  def printMaximumExamples(): Unit = {

    val example: Int = maximum(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))
    println("maximum(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))")
    println(s"Result = ${example}")

    val example2: Double = maximum(
      Branch(Branch(Leaf(11.2), Leaf(8.3)), Branch(Leaf(3.3), Leaf(4.3)))
    )
    println(
      "maximum(Branch(Branch(Leaf(11.2), Leaf(8.3)), Branch(Leaf(3.3), Leaf(4.3))))"
    )
    println(s"Result = ${example2}")
  }

  def depth[A](tree: Tree[A]): Int = {
    fold(tree)(_ => 0)((left, right) => 1 + left.max(right))
  }

  def printDepthExamples(): Unit = {
    val example: Int = depth(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))
    println("depth(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))")
    println(s"Result = ${example}")

    val example2: Int = depth(
      Branch(
        Branch(Branch(Leaf('a'), Branch(Leaf('b'), Leaf('c'))), Leaf('d')),
        Leaf('e')
      )
    )
    println(
      "depth(Branch(Branch(Branch(Leaf('a'), Branch(Leaf('b'), Leaf('c'))), Leaf('d')), Leaf('e')))"
    )
    println(s"Result = ${example2}")
  }

}
