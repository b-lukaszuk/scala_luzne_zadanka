import scala.collection.immutable.HashMap

object ActivityLevel extends Enumeration {
  type ActivityLevel = Value
  val Sedentary, LightlyActive, ModeratelyActive, VeryActive, ExtraActive =
    Value
}

object Nutrients extends Enumeration {
  type Nutrients = Value
  val Carbohydrates, Proteins, Fats = Value
}

object Task4 {
  import ActivityLevel.ActivityLevel
  import Nutrients.Nutrients

  val BMRMultipliers: HashMap[ActivityLevel, Double] = HashMap(
    ActivityLevel.Sedentary -> 1.2,
    ActivityLevel.LightlyActive -> 1.375,
    ActivityLevel.ModeratelyActive -> 1.55,
    ActivityLevel.VeryActive -> 1.725,
    ActivityLevel.ExtraActive -> 1.9
  )

  // (Nutrient, (minKcalPercentage, maxKcalPercentage))
  // percentage written as decimal
  val NutrientsPercentageOfKcal: HashMap[Nutrients, (Double, Double)] =
    HashMap(
      Nutrients.Carbohydrates -> (0.45, 0.65),
      Nutrients.Proteins -> (0.1, 0.3),
      Nutrients.Fats -> (0.2, 0.35)
    )

  // BMR - Basal Metabolic Rate
  def getBMRKcal(
      weightKg: Double,
      heightCm: Double,
      ageYrs: Double,
      sexFemale: Boolean
  ): Double = {
    val BMRBase: Double = 10 * weightKg + 6.25 * heightCm - 5 * ageYrs
    if (sexFemale) BMRBase - 161
    else BMRBase + 5
  }

  // TEE - Total Energy Expended
  def getTEEKcal(
      weightKg: Double,
      heightCm: Double,
      ageYrs: Double,
      sexFemale: Boolean,
      activityLevel: ActivityLevel
  ): Double = {
    val BMR: Double = getBMRKcal(weightKg, heightCm, ageYrs, sexFemale)
    BMR * BMRMultipliers.getOrElse(activityLevel, 0: Double)
  }

  def main(args: Array[String]): Unit = {
    println()
    println("-" * 30)
    println(getBMRKcal(90, 180, 30, false))
    println(getBMRKcal(67, 170, 30, true))
    println(BMRMultipliers.getOrElse(ActivityLevel.LightlyActive, 0))
    println(NutrientsPercentageOfKcal.getOrElse(Nutrients.Carbohydrates, 0))
    println("-" * 30)
    println()
  }
}
