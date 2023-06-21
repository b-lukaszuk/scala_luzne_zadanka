package random:
  private var seed:Long = System.currentTimeMillis
  private val a:Int = 1664525
  private val b:Int = 1013904223
  private val n:Int = 32

  def setSeed(newSeed:Long): Unit =
    seed = newSeed

  def nextDouble():Double =
    val rndDbl:Double = (seed * a + b) % scala.math.pow(2, n)
    setSeed(rndDbl.toLong)
    rndDbl

  def nextInt():Int = nextDouble().toInt

  def getNInts(n:Int = 5) =
    for (_ <- 1 to n) yield nextInt()

  def getNDoubles(n:Int = 5) =
    for (_ <- 1 to n) yield nextDouble()
