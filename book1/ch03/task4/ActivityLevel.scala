package activityLevel

import scala.collection.immutable.HashMap

object ActivityLevel extends Enumeration {
  type ActivityLevel = Value
  val Sedentary, LightlyActive, ModeratelyActive, VeryActive, ExtraActive =
    Value
}

object BMRMultipliers {
  import ActivityLevel.ActivityLevel

  val multipliers: HashMap[ActivityLevel, Double] = HashMap(
    ActivityLevel.Sedentary -> 1.2,
    ActivityLevel.LightlyActive -> 1.375,
    ActivityLevel.ModeratelyActive -> 1.55,
    ActivityLevel.VeryActive -> 1.725,
    ActivityLevel.ExtraActive -> 1.9
  )

  def getActivityMultiplier(activityLevel: ActivityLevel): Double = {
    BMRMultipliers.getOrElse(activityLevel, 0: Double)
  }
}
