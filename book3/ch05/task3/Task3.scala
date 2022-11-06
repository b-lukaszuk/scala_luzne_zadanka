object Task3 {

  class Car(
      val manufacturer: String,
      val modelName: String,
      val modelYear: Int,
      var licensePlate: String
  ) {
    require(
      modelYear > 1885 || modelYear == -1
    ) // Benz Patent Motor Car, model no. 1.

    def this(manufacturer: String, modelName: String, licensePlate: String) {
      this(manufacturer, modelName, -1, licensePlate)
    }

    def this(manufacturer: String, modelYear: Int, licensePlate: String) {
      this(manufacturer, "", modelYear, licensePlate)
    }

    def this(manufacturer: String, licensePlate: String) {
      this(manufacturer, "", -1, licensePlate)
    }

    override def toString(): String = {
      var msg: String = s"Car\n\tmanufacturer: ${manufacturer}"
      msg += s"\n\tmodel name: ${modelName}\n\tmodel year: ${modelYear}"
      msg += s"\n\tlicense plate: ${licensePlate}"
      msg
    }
  }

  def main(args: Array[String]): Unit = {
    println("-" * 30)
    println("Task3.\n")
    val cars: Array[Car] = Array(
      new Car("Volvo", "abc1234"),
      new Car("Ford", "Kia", "bca1234"),
      new Car("Mitsubishi", 1994, "cab1234"),
      new Car("Opel", "Corsa", 2000, "cca1234")
    )
    for (car <- cars) {
      println(car)
    }
    println("\nThat's all. Goodbye!")
    println("-" * 30)
  }
}
