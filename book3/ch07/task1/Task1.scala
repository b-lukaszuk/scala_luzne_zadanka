import random as rnd

object Task1:
  def main(args: Array[String]) =
    println()
    println("-"*20)

    println("Task1. Examples.\n")

    println("Generating 5 random Ints")
    println(rnd.getNInts(5))
    println("Generating 5 random Ints with seed 33.")
    rnd.setSeed(33)
    println(rnd.getNInts(5))
    println("Again. Generating 5 random Ints with seed 33.")
    rnd.setSeed(33)
    println(rnd.getNInts(5))

    println("\nGenerating 5 random Doubles")
    println(rnd.getNDoubles(5))
    println("Again. Generating 5 random Doubles.")
    println(rnd.getNDoubles(5))

    println("\nThat's all. Goodbye.")
    println("-"*20)
    println()
