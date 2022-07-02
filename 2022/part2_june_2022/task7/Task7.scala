object Task7 {
  def main(args: Array[String]): Unit = {

    var usersChoice: Int = 0;
    var convertToCelsius: Boolean = true;
    var usersInputDegrees: Double = 0;

    def fahrenheitToCelsius(fahrenheit: Double): Double = {
      (5 * (fahrenheit - 32)) / 9
    }

    def celsiusToFahrenheit(celsius: Double): Double = {
      (9 * celsius / 5) + 32
    }

    def printMenu(): Unit = {
      println("-" * 5);
      println("What do You want to do?")
      println("1. convert Fahrenheit -> Celsius");
      println("2. convert Celsius -> Fahrenheit");
      println("3. quit");
      println("-" * 5);
      println("Type Your choice:");
    }

    def askForTemperature(): Unit = {
      print("Enter temperature in ");
      println(s"${if (convertToCelsius) "fahrenheit" else "celsius"}");
      usersInputDegrees = scala.io.StdIn.readDouble();
    }

    def declareConvertion(): Unit = {
      var result: Double =
        if (convertToCelsius) fahrenheitToCelsius(usersInputDegrees)
        else celsiusToFahrenheit(usersInputDegrees)
      print(s"${usersInputDegrees}");
      print(s"${if (convertToCelsius) "F" else "C"} = ");
      print(f"$result%.2f");
      println(s"${if (convertToCelsius) "C" else "F"}");
    }

    def handleUsersChoice(): Unit = {
      usersChoice = scala.io.StdIn.readInt();
      usersChoice match {
        case 1 => convertToCelsius = true
        case 2 => convertToCelsius = false
        case 3 => println("Quitting the program.");
        case _ => println("Wrong input. Nothing to do.");
      }
    }

    // no actual loop here
    def programLoop(): Unit = {
      printMenu();
      handleUsersChoice();
      if (usersChoice == 1 || usersChoice == 2) {
        askForTemperature();
        declareConvertion();
      }
    }

    println("Wellcome to temperature converter");
    programLoop();
    println("That's all. Goodbye!");
    println("-" * 30);
  }
}
