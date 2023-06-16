package person:

  import activityLevel.*
  import nutrients.*

  class Person(
      val weightKg: Double,
      val heightCm: Double,
      val ageYears: Double,
      val sexFemale: Boolean,
      val activityLevel: ActivityLevel,
      val poundsPerWeekGainLoss: Double
  ):
    require(weightKg >= 30 && weightKg <= 600)
    require(heightCm >= 140 && heightCm <= 272)
    require(ageYears >= 18 && ageYears <= 123)
    require(poundsPerWeekGainLoss >= -2 && poundsPerWeekGainLoss < 5)

    override def toString(): String =
      var description: String = s"Person\n\tWeight [kg]: ${weightKg}\n"
      description += s"\tHeight [cm]: ${heightCm}\n\tAge [years]: ${ageYears}\n"
      description += s"\tFemale: ${sexFemale}\n\tActivityLevel: ${activityLevel}\n"
      description += s"\tGoal [pounds per week]: ${poundsPerWeekGainLoss}\n"
      description += f"\tDaily BMR [kcal] is: ${getBMRKcalDay()}%.2f\n"
      description += f"\tDaily TEE [kcal]: ${getTEEKcalDay()}%.2f\n"
      description += f"\tDaily TEE [kcal] (adjusted for goal): ${getTEEKcalDayAdjustedByGoal()}%.2f\n"
      description += "\tThe energy (TEE [kcal] adjusted for goal) should come from:\n"
      for (nutrient <- Nutrients.values)
        description += f"\t\t${nutrient}: ${getMinKcalForNutrient(nutrient)}%.2f [kcal] - ${getMaxKcalForNutrient(nutrient)}%.2f [kcal]\n"
      description

    // BMR - Basal Metabolic Rate
    private def getBMRKcalDay(): Double =
      val BMRBase: Double = 10 * weightKg + 6.25 * heightCm - 5 * ageYears
      if (sexFemale) BMRBase - 161
      else BMRBase + 5

    // TEE - Total Energy Expended
    private def getTEEKcalDay(): Double =
      val BMR: Double = getBMRKcalDay()
      BMR * BMRMultipliers.getActivityMultiplier(activityLevel)

    // poundsPerWeekGainLoss, e.g. +1, -2 (if gain/lose n ponds per week)
    private def getTEEKcalDayAdjustedByGoal(): Double =
      val TEEKcalDay: Double = getTEEKcalDay()
      TEEKcalDay + (poundsPerWeekGainLoss * 500) // 3500 kcal / 7 days = 500 kcal/day


    private def getMinKcalForNutrient(nutrient: Nutrients): Double =
      val decimal: Double =
        NutrientsPercentageOfKcal.getPercentageOfKcal(nutrient)._1
      getTEEKcalDayAdjustedByGoal() * decimal


    private def getMaxKcalForNutrient(nutrient: Nutrients): Double =
      val decimal: Double =
        NutrientsPercentageOfKcal.getPercentageOfKcal(nutrient)._2
      getTEEKcalDayAdjustedByGoal() * decimal
