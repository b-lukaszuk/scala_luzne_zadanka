object Task7 {
  def main(args: Array[String]): Unit = {

    def fahrenheitToCelsius(fahrenheit: Double): Double = {
      (5 * (fahrenheit - 32)) / 9
    }

    def celsiusToFahrenheit(celsius: Double): Double = {
      (9 * celsius / 5) + 32
    }

    println("Task 7");
    println("-" * 30);
    println("That's all. Goodbye!");
    println("-" * 30);
  }
}
