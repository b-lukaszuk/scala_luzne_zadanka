package tree

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def map[A, B](tree: Tree[A])(fn: A => B): Tree[B] = tree match {
    case Leaf(x)             => Leaf(fn(x))
    case Branch(left, right) => Branch(map(left)(fn), map(right)(fn))
  }

  val example: Tree[Int] = map(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))(_ * 2)
  val example2: Tree[Float] =
    map(Branch(Leaf(13), Branch(Leaf(2), Leaf(5))))(_.toFloat / 2)
  val example3: Tree[Int] = map(
    Branch(Leaf('a'), Branch(Leaf('b'), Branch(Leaf('c'), Leaf('d'))))
  )(_.toInt)

  def printFoldExamples(): Unit = {

    println("map(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))(_ * 2)")
    println(s"result: ${example}\n")

    println("map(Branch(Leaf(13), Branch(Leaf(2), Leaf(5))))(_.toFloat / 2)")
    println(s"result: ${example2}\n")

    println(
      "map(Branch(Leaf('a'), Branch(Leaf('b'), Branch(Leaf('c'), Leaf('d')))))(_.toInt)"
    )
    println(s"result: ${example3}\n")
  }
}
