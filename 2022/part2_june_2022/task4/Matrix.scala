package matrix;

class Matrix(val matrix: Array[Array[Int]]) {
  require(
    matrix.map(row => row.size).toSet.size == 1,
    "Matrix requires a non-empty array with the same number of elements per every row"
  );

  private def getNRows(): Int = {
    matrix.length;
  }

  // assumes all rows are of equal length/size - see require above
  private def getNCols(): Int = {
    matrix(0).length;
  }

  private def getRow(num: Int): Array[Int] = {
    matrix(num);
  }

  private def getCol(colNum: Int): Array[Int] = {
    var col: Array[Int] = Array[Int]();
    matrix.foreach(row => { col :+= row(colNum) });
    col;
  }

  private def areDimsCompatForMult(other: Matrix): Boolean = {
    this.getNCols == other.getNRows;
  }

  private def dotProduct(arr1: Array[Int], arr2: Array[Int]): Int = {
    var result: Array[Int] = Array.fill(arr1.length) { 0 };
    for (i <- 0 to (arr1.length - 1)) {
      result(i) = arr1(i) * arr2(i)
    }
    result.reduce((a, b) => a + b);
  }

  // https://www.mathsisfun.com/algebra/matrix-multiplying.html
  private def mult(other: Matrix): Array[Array[Int]] = {
    var result: Array[Array[Int]] = Array[Array[Int]]();
    for (r1 <- 0 to (this.getNRows - 1)) {
      var row: Array[Int] = Array[Int]();
      for (c2 <- 0 to (other.getNCols - 1)) {
        row :+= this.dotProduct(this.getRow(r1), other.getCol(c2));
      }
      result :+= row;
    }
    result;
  }

  def multiplyAndPrint(other: Matrix): Unit = {
    println("\nmultiplying:");
    println(this.toString);
    println("by:")
    println(other.toString);
    println("result:");
    if (areDimsCompatForMult(other)) {
      println(new Matrix(mult(other)).toString);
    } else {
      println("Error in [r1, c1]*[r2, c2]. c1 not equal to r2");
    }
    println();
  }

  override def toString(): String = {
    matrix
      .map((row) => {
        row.map((digit) => "%3d".format(digit)).mkString(", ")
      })
      .mkString("\n");
  }
}
