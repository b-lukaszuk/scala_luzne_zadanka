package random:
  var seed:Int = 123
  val a:Int = 1664525
  val b:Int = 1013904223
  val n:Int = 32

  def setSeed(newSeed:Int): Unit =
    seed = newSeed

  def nextDouble():Double =
    val rndDbl:Double = (seed * a + b) % scala.math.pow(2, n)
    setSeed(rndDbl.toInt)
    rndDbl

  def nextInt():Int = nextDouble().toInt
