import option._

object Task1:
  def main(args: Array[String]) =
    println("\nOption.map examples:")
    Option.printMapExamples()

    println("\nOption.getOrElse examples:")
    Option.printGetOrElseExamples()

    println("\nOption.flatMap examples:")
    Option.printFlatMapExamples()

    println("\nOption.filter examples:")
    Option.printFilterExamples()

    println("\nThat's all. Goodbye!\n")
