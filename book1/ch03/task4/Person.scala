package person

import activityLevel._

class Person(
    val weightKg: Double,
    val heightCm: Double,
    val ageYears: Double,
    val sexFemale: Boolean,
    val activityLevel: ActivityLevel.ActivityLevel,
    val poundsPerWeekGainLoss: Double
) {

  override def toString(): String = {
    var description: String = s"Person\n\tWeight [kg]: ${weightKg}\n"
    description += s"\tHeight [cm]: ${heightCm}\n\tAge [years]: ${ageYears}\n"
    description += s"\tFemale: ${sexFemale}\n\tActivityLevel: ${activityLevel}\n"
    description += s"\tGoal [pounds per week]: ${poundsPerWeekGainLoss}"
    description
  }

  // BMR - Basal Metabolic Rate
  private def getBMRKcalDay(): Double = {
    val BMRBase: Double = 10 * weightKg + 6.25 * heightCm - 5 * ageYears
    if (sexFemale) BMRBase - 161
    else BMRBase + 5
  }

  // TEE - Total Energy Expended
  private def getTEEKcalDay(): Double = {
    val BMR: Double = getBMRKcalDay()
    BMR * BMRMultipliers.getActivityMultiplier(activityLevel)
  }

  // poundsPerWeekGainLoss, e.g. +1, -2 (if gain/lose n ponds per week)
  private def getTEEKcalDayAdjustByGoal(): Double = {
    val TEEKcalDay: Double =
      getTEEKcalDay()
    TEEKcalDay - (poundsPerWeekGainLoss * 3500 / 7)
  }
}
