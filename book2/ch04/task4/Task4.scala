import java.util.regex._

object Task4:
  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
    (a, b) match
      case (_, None) => None
      case (None, _) => None
      case (a, b)    => a.map((ai: A) => f(ai, b.get))

  def pattern(s: String): Option[Pattern] =
    try
      Some(Pattern.compile(s))
    catch
      case e: PatternSyntaxException => None

  def mkMatcher(pat: String): Option[String => Boolean] =
    pattern(pat) map (p => (s: String) => p.matcher(s).find)

  def bothMatch_2(pat1: String, pat2: String, s: String): Option[Boolean] =
    map2(mkMatcher(pat1), mkMatcher(pat2))(
      (p1: String => Boolean, p2: String => Boolean) => p1(s) && p2(s)
    )

  def main(args: Array[String]): Unit =
    val example: Option[Boolean] = bothMatch_2("ala", "kota", "ala ma kota")
    val example2: Option[Boolean] = bothMatch_2("ala", "kota", "ala ma kotka")
    val example3: Option[Boolean] = bothMatch_2("(", "kota", "ala ma kotka")

    println("\n" + "-" * 30)
    println("Task4")
    println("\nbothMatch_2 examples:\n")
    println("bothMatch_2(\"ala\", \"kota\", \"ala ma kota\")")
    println(s"Result: ${example}\n")
    println("bothMatch_2(\"ala\", \"kota\", \"ala ma kotka\")")
    println(s"Result: ${example2}\n")
    println("bothMatch_2(\"(\", \"kota\", \"ala ma kotka\")")
    println(s"Result: ${example3}\n")
    println("That's all. Goodbye!")
    println("-" * 30 + "\n")
