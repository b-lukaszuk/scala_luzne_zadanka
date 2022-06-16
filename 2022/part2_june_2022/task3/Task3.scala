import scala.collection.mutable.HashMap

object Task3 {
  def main(args: Array[String]): Unit = {

    val wrdsPairs: Array[Array[String]] =
      Array(
        Array("Lorem ipsum dolor sit amet.", "Dolor at pulvo ni soda."),
        Array("rak", "kajak"),
        Array("medicine", "house med. dr"),
        Array("ala", "emu"),
        Array("ala", "")
      );

    def getSubstrsOfLen(wrd: String, len: Int): List[String] = {
      var result: List[String] = List();
      for (i <- 0 to (wrd.length - len)) {
        result +:= wrd.slice(i, i + len)
      }
      result.reverse;
    }

    def areWrdsEql(wrd1: String, wrd2: String): Boolean = {
      wrd1 == wrd2;
    }

    def isWrdInArr(wrd: String, wrds: Array[String]): Boolean = {
      var counter: Int = 0;
      var result: Boolean = false;
      while (counter < wrds.length) {
        if (areWrdsEql(wrd, wrds(counter))) {
          counter = wrds.length;
          result = true;
        }
        result;
      }
    }

    def findLongestOverlap(wrd1: String, wrd2: String): String = {
      var counter: Int = wrd1.length.min(wrd2.length);
      var result: String = "";
      while (counter > 0) {}
    }

    def testAndDeclare(wrd: String): Unit = {
      println(s"Testing '${wrd}'");
      println("First longest palindrome found:");
      println(getLongestPalindrome(wrd));
    }

    println("-" * 30)
    wrds.foreach(testAndDeclare(_));
    println("-" * 30)
  }
}
