object Task5_3 {
  def main(args: Array[String]): Unit = {

    class ResOfAddSubMultDiv(
        val add: Double,
        val subtr: Double,
        val mult: Double,
        val div: Double
    ) {
      override def toString(): String = {
        s"{\nadd: ${this.add},\nsubtr: ${this.subtr},\nmult: ${this.mult},\ndiv: ${this.div}\n}"
      }
    }

    // be careful it's not idiot-proof (e.g does not check for div by 0)
    def returnObjWith4Fields(a: Double, b: Double): ResOfAddSubMultDiv = {
      val mathOper = new ResOfAddSubMultDiv(a + b, a - b, a * b, a / b)
      mathOper
    }

    val a: Double = 2
    val b: Double = 4

    println("-" * 50)
    println("Task 5.3")
    println(s"I pass two digits ${a} and ${b} to a function")
    println("and create an object with 4 fields (results of +, -, *, /)")
    println("behold:")
    println(returnObjWith4Fields(a, b).toString())
    println("-" * 50)
  }
}
