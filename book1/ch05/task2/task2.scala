import scala.math.pow

@scala.annotation.tailrec
def getPower(num:Int, pow:Int, acc:Int=1):Int =
  require (pow >= 0)
  if (pow == 0) then acc else getPower(num, pow-1, acc*num)

@main def task2: Unit =
  println()
  println("-" * 30)
  println("Recursive power function. Examples")
  for (n <- 0 to 5)
    for (p <- 0 to 5)
      print(s"${n}^${p} = ")
      println(s"my fn: ${getPower(n, p)}, build-in fn: ${pow(n, p)}")
      println(s"Test passed? ${getPower(n, p) == pow(n, p)}")
  println("\nThat's all. Goodbye!")
  println("-" * 30)
  println()
