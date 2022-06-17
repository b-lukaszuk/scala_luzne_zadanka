object Task2 {
  def main(args: Array[String]): Unit = {

    val wrds: Array[String] =
      Array("bird", "karak", "baerren", "kajak", "inni", "sedes", "puppet");

    def isPalindrome(wrd: String): Boolean = {
      wrd == wrd.reverse;
    }

    def getSubstrsOfLen(wrd: String, len: Int): List[String] = {
      var result: List[String] = List();
      for (i <- 0 to (wrd.length - len)) {
        result +:= wrd.slice(i, i + len);
      }
      result.reverse;
    }

    def getLongestPalindrome(wrd: String): String = {
      var counter: Int = wrd.length;
      var result: List[String] = List();
      while (counter > 0) {
        result = getSubstrsOfLen(wrd, counter).filter(isPalindrome(_));
        if (!result.isEmpty) { counter = 0 }
        counter -= 1;
      }
      result.head;
    }

    def testAndDeclare(wrd: String): Unit = {
      println(s"Testing '${wrd}'");
      println("First longest palindrome found:");
      println(getLongestPalindrome(wrd));
    }

    println("-" * 30);
    wrds.foreach(testAndDeclare(_));
    println("-" * 30);
  }
}
