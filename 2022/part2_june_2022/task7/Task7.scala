object Task7 {
  def main(args: Array[String]): Unit = {

    var usersChoiceInMenu: Int = 0;
    var isInputFahrenheit: Boolean = true;
    var usersInputDegrees: Double = 0;

    def fahrenheitToCelsius(fahrenheit: Double = usersInputDegrees): Double = {
      (5 * (fahrenheit - 32)) / 9
    }

    def celsiusToFahrenheit(celsius: Double = usersInputDegrees): Double = {
      (9 * celsius / 5) + 32
    }

    def isAboveAbsolute0(
        temp: Double = usersInputDegrees,
        isFahrenheit: Boolean = isInputFahrenheit
    ): Boolean = {
      if (isFahrenheit) temp < -459.67 else temp < -273.15
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

    def askForTempSetUsersInputDegrees(): Unit = {
      print("Enter temperature in ");
      println(s"${if (isInputFahrenheit) "fahrenheit" else "celsius"}");
      usersInputDegrees = scala.io.StdIn.readDouble();
    }

    def declareConvertion(
        temp: Double = usersInputDegrees,
        isTempInFahrenheit: Boolean = isInputFahrenheit
    ): Unit = {
      var result: Double =
        if (isTempInFahrenheit) fahrenheitToCelsius(temp)
        else celsiusToFahrenheit()
      print(s"${temp}");
      print(s"${if (isTempInFahrenheit) "F" else "C"} = ");
      print(f"$result%.2f");
      println(s"${if (isTempInFahrenheit) "C" else "F"}");
    }

    def handleUsersMenuChoice(): Unit = {
      usersChoiceInMenu = scala.io.StdIn.readInt();
      usersChoiceInMenu match {
        case 1 => isInputFahrenheit = true
        case 2 => isInputFahrenheit = false
        case 3 => println("Quitting the program.");
        case _ => println("Wrong input. Nothing to do.");
      }
    }

    // no actual loop here
    def programLoop(): Unit = {
      printMenu();
      handleUsersMenuChoice();
      askForTempSetUsersInputDegrees();
      if (isAboveAbsolute0()) {
        println("The temperature must be above 0 degrees Kelvin");
        println("Nothing to do.");
      } else if (usersChoiceInMenu == 1 || usersChoiceInMenu == 2) {
        declareConvertion();
      }
    }

    println("Wellcome to temperature converter");
    programLoop();
    println("That's all. Goodbye!");
    println("-" * 30);
  }
}
