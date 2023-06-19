import random as rnd

object Task1:
  def main(args: Array[String]) =
    println()
    println("-"*20)

    println("Task1. Examples.\n")

    println("Generating 5 random Ints with seed 33.")
    rnd.setSeed(33)
    for (_ <- 1 to 5)
      println(rnd.nextInt())
    println("Again. Generating 5 random Ints with seed 33.")
    rnd.setSeed(33)
    for (_ <- 1 to 5)
      println(rnd.nextInt())

    println("\nGenerating 5 random Doubles with seed 12.")
    rnd.setSeed(12)
    for (_ <- 1 to 5)
      println(rnd.nextDouble())
    println("Generating 5 random Doubles with seed 23.")
    rnd.setSeed(23)
    for (_ <- 1 to 5)
      println(rnd.nextDouble())

    println("\nThat's all. Goodbye.")
    println("-"*20)
    println()
