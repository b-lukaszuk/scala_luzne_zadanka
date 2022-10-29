object Task3 {

  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
    (a, b) match {
      case (a, None) => None
      case (None, b) => None
      case (a, b)    => a.map((i: A) => f(i, b.get))
    }

  def main(args: Array[String]): Unit = {

    val example: Option[Int] = map2(Some(1), Some(2))((x: Int, y: Int) => x + y)
    val example2: Option[String] =
      map2(Some("Tom"), Some("Jerry"))((x: String, y: String) => s"${x} & ${y}")

    println("\n" + "-" * 30)
    println("Task3")
    println("\nMap2 examples:\n")
    println("map2(Some(1), Some(2))((x: Int, y: Int) => x + y)")
    println(s"Result: ${example}\n")
    println(
      "map2(Some(\"Tom\"), Some(\"Jerry\"))((x: String, y: String) => s\"${x} & ${y}\")"
    )
    println(s"Result: ${example2}\n")
    println("That's all. Goodbye!")
    println("-" * 30 + "\n")
  }
}
