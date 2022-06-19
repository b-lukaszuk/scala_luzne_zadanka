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

    println("-" * 30);
    println(matr1.toString);
    println("-" * 30);
  }
}
