import scala.annotation.tailrec

/** calculates the number of rabbits in a population after a cycle
  *
  * @param rN - number of rabbits at the beginning of a cycle
  * @param a - normal increase in the rabbit population, e.g. 0.1 for +10%
  * @param b - predation rate in decimal (0.1 = 10%, etc.)
  * @param fN - number of foxes at the beginning of a cycle
  *
  * @return - the new number of rabbits in a population after a cycle
  */
def getRabbits(rN:Double, a:Double, b:Double, fN:Double):Double =
  rN + a * rN - b * rN * fN

/** calculates the number of foxes in a population after a cycle
  *
  * @param fN - number of foxes at the beginning of a cycle
  * @param c - rate of foxes dying w/o children since there is no food (rabbits)
  * @param d - rate at which foxes have children when they have food (rabbits)
  * @param rN - number of rabbits at the beginning of a cycle
  *
  * @return - the new number of foxes in a population after a cycle
  */
def getFoxes(fN:Double, c:Double, d:Double, rN:Double):Double =
  fN - c * fN + d * rN * fN

/** calculates the number of rabbits and foxes in a population after a cycle
  *
  * @param prevPop - (iterNum, rabbitsPop, foxesPop)
  * @param a - normal increase in the rabbit population, e.g. 0.1 for +10%
  * @param b - predation rate in decimal (0.1 = 10%, etc.)
  * @param c - rate of foxes dying w/o children since there is no food (rabbits)
  * @param d - rate at which foxes have children when they have food (rabbits)
  *
  * @return - the new number of rabbits and foxes in a population after a cycle
  */
def getPopulations(
  prevPop: (Int, Double, Double) = (0, 100, 10),
  a:Double=0.01,
  b:Double=0.001,
  c:Double=0.05,
  d:Double=0.001): (Int, Double, Double) =
  val (nIter, nRab, nFox) = prevPop
  (nIter + 1, getRabbits(nRab, a, b, nFox), getFoxes(nFox, c, d, nRab))

/** calculates numbers of rabbits and foxes in populations after nIter cycles
  *
  * @param startPop - List[(iterNum, rabbitsPop, foxesPop)]
  * @param a - normal increase in the rabbit population, e.g. 0.1 for +10%
  * @param b - predation rate in decimal (0.1 = 10%, etc.)
  * @param c - rate of foxes dying w/o children since there is no food (rabbits)
  * @param d - rate at which foxes have children when they have food (rabbits)
  * @param nIter - number of cycles
  *
  * @return - the numbers of rabbits and foxes in populations after nIter cycles
  */
@tailrec
def getPopulationChanges(
  startPop: List[(Int, Double, Double)] = (0, 100, 10)::Nil,
  a:Double=0.01,
  b:Double=0.001,
  c:Double=0.05,
  d:Double=0.001,
  nIter:Int = 1000): List[(Int, Double, Double)] =
  if (nIter <= 0)
    startPop.reverse
  else
    getPopulationChanges(
      getPopulations(startPop.head, a, b, c, d) :: startPop,
      a, b, c, d, nIter - 1
    )

def printNoArgsMessage(): Unit =
    println("To work properly I need 6 arguments Rn, Fn, A, B, C, D.")
    println("For instance: scala3 task10.scala 100 10 0.01 0.001 0.05 0.001")
    println("Rn - initial number of rabbits,")
    println("Fn - initial number of foxes,")
    println("A - normal increase in the rabbit population, e.g. 0.1 for +10%")
    println("B - predation rate in decimal (0.1 = 10%, etc.)")
    println("C - rate foxes dying w/o children cause no food (rabbits)")
    println("D - rate foxes have children when they have food (rabbits)")

@main def task5(vargs:String*): Unit =
  if (vargs.length == 0)
    printNoArgsMessage()
  else
    // Recursive functions for populations changes example
    val Seq(rN: Double, fN: Double,
      a: Double, b: Double, c: Double, d: Double) =
      vargs.slice(0, 6).map(_.toDouble)
    for (population <- getPopulationChanges((0, rN, fN)::Nil, a, b, c, d))
      val (i, r, f) = population
      println(s"$i $r $f")
