object Task6 {
  def main(args: Array[String]): Unit = {

    def revString(text: String): String = {
      text.foldLeft("")((acc, c) => c + acc)
    }

    def revInt(num: Int): Int = {
      var result: Int = revString(num.abs.toString).toInt
      if (num < 0) { result *= (-1) }
      result
    }

    val toReverse1: String = "tomek"
    val toReverse2: Int = 1234
    val toReverse3: Int = -9876

    println("-" * 50)
    println(s"Reversing string <${toReverse1}>:")
    println(revString(toReverse1))
    println(s"Reversing Int <${toReverse2}>:")
    println(revInt(toReverse2))
    println(s"Reversing Int <${toReverse3}>:")
    println(revInt(toReverse3))
    println("That's it. Goodbye!")
    println("-" * 50)
  }
}
