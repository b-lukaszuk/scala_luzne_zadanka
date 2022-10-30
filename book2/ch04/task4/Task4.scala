import java.util.regex._

object Task4 {

  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
    (a, b) match {
      case (_, None) => None
      case (None, _) => None
      case (a, b)    => a.map((ai: A) => f(ai, b.get))
    }

  def pattern(s: String): Option[Pattern] =
    try {
      Some(Pattern.compile(s))
    } catch {
      case e: PatternSyntaxException => None
    }

  def mkMatcher(pat: String): Option[String => Boolean] =
    pattern(pat) map (p => (s: String) => p.matcher(s).find)

  def main(args: Array[String]): Unit = {

    println("\n" + "-" * 30)
    println("Task4")
    println("\nbothMatch_2 examples:\n")
    println(mkMatcher("ala").get("ala ma kota"))
    println(s"Result: \n")
    println("That's all. Goodbye!")
    println("-" * 30 + "\n")
  }
}
