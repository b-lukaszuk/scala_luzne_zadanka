import scala.collection.mutable.HashMap

object Task3 {
  def main(args: Array[String]): Unit = {

    val wrdsPairs: Array[Array[String]] =
      Array(
        Array("Lorem ipsum dolor sit amet.", "Dolor at pulvo ni soda."),
        Array("rak", "kajak"),
        Array("medicine", "house med. dr"),
        Array("ala", "emu"),
        Array("ala", ""),
        Array("Tomek", "tomeczek")
      );

    def getSubstrsOfLen(wrd: String, len: Int): Array[String] = {
      var result: Array[String] = Array[String]();
      for (i <- 0 to (wrd.length - len)) {
        result :+= wrd.slice(i, i + len)
      }
      result;
    }

    def isWrdInArr(wrd: String, wrds: Array[String]): Boolean = {
      var result: Boolean = false;
      var counter: Int = 0;
      while (counter < wrds.length && !result) {
        if (wrd.toLowerCase == wrds(counter).toLowerCase) { result = true }
        counter += 1;
      }
      result;
    }

    def getOverlapOfLen(wrd1: String, wrd2: String, len: Int): String = {
      var counter: Int = 0;
      var result: String = "";
      val wrds1: Array[String] = getSubstrsOfLen(wrd1, len);
      val wrds2: Array[String] = getSubstrsOfLen(wrd2, len);
      while (counter < wrds1.length && result == "") {
        if (isWrdInArr(wrds1(counter), wrds2)) { result = wrds1(counter) }
        counter += 1;
      }
      result.toLowerCase;
    }

    def findLongestOverlap(wrd1: String, wrd2: String): String = {
      var counter: Int = wrd1.length.min(wrd2.length);
      var result: String = "";
      while (counter > 0 && result == "") {
        result = getOverlapOfLen(wrd1, wrd2, counter);
        counter -= 1;
      }
      result;
    }

    def testAndDeclare(wrd1: String, wrd2: String): Unit = {
      println("-")
      println(
        s"Testing (case insensitive) '${wrd1}' and '${wrd2}' for overlap"
      );
      println(s"result: '${findLongestOverlap(wrd1, wrd2)}'");
      println("-")
    }

    println("-" * 30)
    wrdsPairs.foreach((a) => testAndDeclare(a(0), a(1)))
    println("-" * 30)
  }
}
