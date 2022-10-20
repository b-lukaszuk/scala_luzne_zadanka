package option

sealed trait Option[+A]
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]

object Option {
  def printHello() = println("Hello from Option")

  def map[A, B](option: Option[A])(f: A => B): Option[B] = option match {
    case None    => None
    case Some(a) => Some(f(a))
  }

  def printMapExamples(): Unit = {
    val example: Option[Int] = map(Some(2))((x: Int) => x + 11)
    val example2: Option[Int] = map(None)((x: Int) => x + 11)
    println(s"map(Some(2))((x: Int) => x + 11) = ${example}")
    println(s"map(None)((x: Int) => x + 11) = ${example2}")
  }

  def flatMap[A, B](option: Option[A])(f: A => Option[B]): Option[B] =
    option match {
      case None    => None
      case Some(a) => f(a)
    }

  def printFlatMapExamples(): Unit = {
    val example: Option[Char] = flatMap(Some(2))((_: Int) => Some('c'))
    val example2: Option[Int] = flatMap(None)((x: Int) => Some(x + 11))
    println(s"flatMap(Some(2))((_: Int) => Some('c')) = ${example}")
    println(s"flatMap(None)((x: Int) => Some(x + 11)) = ${example2}")
  }

  // explanation of '[B >: A]'
  // https://docs.scala-lang.org/tour/lower-type-bounds.html
  // explanation of 'default: => B'
  // https://users.scala-lang.org/t/what-does-x-int-mean-in-scala/5558
  def getOrElse[A, B >: A](option: Option[A])(default: => B): B = option match {
    case None => default
    case Some(a) => a
  }

  def printGetOrElseExamples(): Unit = {
    val example: Int = getOrElse(Some(3))(4)
    val example2: Int = getOrElse(None)(5)
    println(s"getOrElse(Some(3))(4) = ${example}")
    println(s"getOrElse(None)(5) = ${example2}")

  }

}
