package matrix

class Matrix(val matrix: Array[Array[Int]]) {

  private def nRows(): Int = {
    matrix.length;
  }

  // assumes all rows got equal length
  private def nCols(): Int = {
    matrix(0).length;
  }

  private def areDimsCompatForMult(other: Matrix): Boolean = {
    this.nCols == other.nRows;
  }

  private def dotProduct(arr1: Array[Int], arr2: Array[Int]): Int = {
    var result: Array[Int] = Array.fill(arr1.length) { 0 };
    for (i <- 0 to (arr1.length - 1)) {
      result(i) = arr1(i) * arr2(i)
    }
    result.reduce((a, b) => a + b);
  }

//   private def multiply(other: Matrix) = {}

// https://www.mathsisfun.com/algebra/matrix-multiplying.html
//   def mult(other: Matrix) = {
//     if (areDimsCompatForMult(other)) {
//       // multiply
//     } else {
//       throw new ArithmeticException(
//         "in [r1, c1] * [r2, c2] c1 must be equal to r2"
//       );
//     }
//   }

  override def toString(): String = {
    matrix
      .map((row) => {
        row.map((digit) => "%3d".format(digit)).mkString(", ")
      })
      .mkString("\n");
  }
}
