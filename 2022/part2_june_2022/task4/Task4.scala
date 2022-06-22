import matrix.Matrix;

object Task4 {
  def main(args: Array[String]): Unit = {

// https://www.mathsisfun.com/algebra/matrix-multiplying.html
    val matr1: Matrix = new Matrix(
      Array(Array(1, 2, 3), Array(4, 5, 6))
    );
    val matr2: Matrix = new Matrix(
      Array(Array(7, 8), Array(9, 10), Array(11, 12))
    );
    val matr3: Matrix = new Matrix(
      Array(Array(7, 8, 9), Array(10, 11, 12))
    );
    val matr4: Matrix = new Matrix(Array(Array(3, 4, 2)));
    val matr5: Matrix = new Matrix(
      Array(
        Array(13, 9, 7, 15),
        Array(8, 7, 4, 6),
        Array(6, 4, 0, 3)
      )
    );

    println("-" * 30);
    matr1.multiplyAndPrint(matr2);
    matr1.multiplyAndPrint(matr3);
    matr1.multiplyAndPrint(matr3);
    matr4.multiplyAndPrint(matr5);
    println("-" * 30);
  }
}
