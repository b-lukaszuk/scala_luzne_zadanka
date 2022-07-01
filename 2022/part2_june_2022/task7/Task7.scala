object Task7 {
  def main(args: Array[String]): Unit = {

    var shouldEndProgram: Boolean = false;
    var usersChoice: Int = 0;

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

    def programLoop(): Unit = {
      while (!shouldEndProgram) {
        printMenu();
        usersChoice = scala.io.StdIn.readInt();
        if (usersChoice == 3) {
          shouldEndProgram = true;
          println("quitting the program");
        } else {
          println(s"You typed: ${usersChoice}")
          println("quitting the program");
          shouldEndProgram = true;
        }
      }
    }

    println("Task 7");
    println("-" * 30);
    programLoop();
    println("That's all. Goodbye!");
    println("-" * 30);
  }
}
