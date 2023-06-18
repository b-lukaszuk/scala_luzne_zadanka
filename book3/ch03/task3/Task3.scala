object Task3:
  def main(args: Array[String]): Unit = 
    val example1: Array[Int] = Array(1, 2, 3, 3, 4, 5)
    val example2: Array[Char] = Array('c', 'a', 'b', 'c', 'b', 'k')
    val example3: Array[String] =
      Array("ala", "ma", "kota", "kota", "ma", "ala")

    println("-" * 30)
    println("Task3.")
    println(s"Removing duplicates from: ${example1.mkString("[", ", ", "]")}")
    println(s"Result: ${example1.distinct.mkString("[", ", ", "]")}")
    println(s"Removing duplicates from: ${example2.mkString("[", ", ", "]")}")
    println(s"Result: ${example2.distinct.mkString("[", ", ", "]")}")
    println(s"Removing duplicates from: ${example3.mkString("[", ", ", "]")}")
    println(s"Result: ${example3.distinct.mkString("[", ", ", "]")}")
    println("That's all. Goodbye!")
    println("-" * 30)
