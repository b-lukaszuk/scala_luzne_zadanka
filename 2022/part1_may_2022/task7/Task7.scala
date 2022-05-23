object Task7 {
  def main(args: Array[String]): Unit = {

    var peopleInCave: Array[Int] = Range(1, 8).toArray

    def declareKill(pplInCave: Array[Int]): Unit = {
      println(s"${pplInCave(0)} kills ${pplInCave(1)}")
    }

    def getPeopleAfterKill(prevPeople: Array[Int]): Array[Int] = {
      Array.concat(
        prevPeople.slice(2, prevPeople.length),
        prevPeople.slice(0, 1)
      )
    }

    def runKillingSpree(): Unit = {
      while (peopleInCave.length != 1) {
        declareKill(peopleInCave)
        peopleInCave = getPeopleAfterKill(peopleInCave)
      }
    }

    println("-" * 50)
    println("At first in the cave there are 7 people:")
    println(peopleInCave.mkString(", "))
    runKillingSpree()
    println(s"In the end only ${peopleInCave(0)} is alive")
    println("That's it. Goodbye!")
    println("-" * 50)
  }
}
