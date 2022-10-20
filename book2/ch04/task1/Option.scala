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

}
