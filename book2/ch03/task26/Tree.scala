package tree:

  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  object Tree:
    def maximum(ints: Tree[Int]): Int = ints match
      case Leaf(x)             => x
      case Branch(left, right) => maximum(left).max(maximum(right))

    val example: Int = maximum(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))
    val example2: Int = maximum(Branch(Leaf(13), Branch(Leaf(2), Leaf(5))))
    val example3: Int = maximum(
      Branch(Leaf(13), Branch(Leaf(2), Branch(Leaf(15), Leaf(4))))
    )

    def printMaximumExamples(): Unit =
      println("maximum(Branch(Leaf(3), Branch(Leaf(2), Leaf(5))))")
      println(s"result: ${example}\n")

      println("maximum(Branch(Leaf(13), Branch(Leaf(2), Leaf(5))))")
      println(s"result: ${example2}\n")

      println(
        "maximum(Branch(Leaf(13), Branch(Leaf(2), Branch(Leaf(15), Leaf(4)))))"
      )
      println(s"result: ${example3}\n")
