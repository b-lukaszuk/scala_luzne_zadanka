package nutrients:

  import scala.collection.immutable.HashMap

  enum Nutrients:
    case Carbohydrates, Proteins, Fats

  // (Nutrient, (minKcalPercentage, maxKcalPercentage))
  // percentage written as decimal
  object NutrientsPercentageOfKcal:
      val percentagesKcalMinMax: HashMap[Nutrients, (Double, Double)] = HashMap(
          Nutrients.Carbohydrates -> (0.45, 0.65),
          Nutrients.Proteins -> (0.1, 0.3),
          Nutrients.Fats -> (0.2, 0.35)
        )

      def getPercentageOfKcal(nutrient: Nutrients): (Double, Double) =
          percentagesKcalMinMax.getOrElse(nutrient, (0: Double, 0: Double))
