package activityLevel:

  import scala.collection.immutable.HashMap

  enum ActivityLevel:
    case Sedentary, LightlyActive, ModeratelyActive, VeryActive, ExtraActive

  object BMRMultipliers:
    val multipliers: HashMap[ActivityLevel, Double] = HashMap(
          ActivityLevel.Sedentary -> 1.2,
          ActivityLevel.LightlyActive -> 1.375,
          ActivityLevel.ModeratelyActive -> 1.55,
          ActivityLevel.VeryActive -> 1.725,
          ActivityLevel.ExtraActive -> 1.9
        )

    def getActivityMultiplier(activityLevel: ActivityLevel): Double =
          multipliers.getOrElse(activityLevel, 0: Double)
