sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](leaf: Tree[A], right: Tree[A]) extends Tree[A]
