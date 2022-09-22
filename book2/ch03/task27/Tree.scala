package tree

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def depth[A](tree: Tree[A]): Int = tree match {
    case Leaf(_)             => 0
    case Branch(left, right) => (1 + depth(left)).max(1 + depth(right))
  }

  val example: Int = depth(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))
  val example2: Int = depth(Branch(Leaf(13), Branch(Leaf(2), Leaf(5))))
  val example3: Int = depth(
    Branch(Leaf(13), Branch(Leaf(2), Branch(Leaf(15), Leaf(4))))
  )

  def printDepthExamples(): Unit = {

    println("depth(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))")
    println(s"result: ${example}\n")

    println("depth(Branch(Leaf(13), Branch(Leaf(2), Leaf(5))))")
    println(s"result: ${example2}\n")

    println(
      "depth(Branch(Leaf(13), Branch(Leaf(2), Branch(Leaf(15), Leaf(4)))))"
    )
    println(s"result: ${example3}\n")
  }
}
