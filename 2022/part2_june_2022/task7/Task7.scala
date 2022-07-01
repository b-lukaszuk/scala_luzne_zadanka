object Task7 {
  def main(args: Array[String]): Unit = {

    def fahrenheitToCelsius(fahrenheit: Double): Double = {
      (5 * (fahrenheit - 32)) / 9
    }

    def celsiusToFahrenheit(celsius: Double): Double = {
      (9 * celsius / 5) + 32
    }

    def printMenu(): Unit = {
      println("-" * 5);
      println("What do You want to do?")
      println("1. convert temperature Fahrenheit -> Celsius");
      println("2. convert temperature Celsius -> Fahrenheit");
      println("3. quit");
      println("-" * 5);
      println("Type Your choice:");
    }

    println("Task 7");
    println("-" * 30);
    println("That's all. Goodbye!");
    println("-" * 30);
  }
}
