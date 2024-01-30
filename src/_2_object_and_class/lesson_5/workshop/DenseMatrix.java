package _2_object_and_class.lesson_5.workshop;

 /**
 * Представляет матрицу (m x n)
 */

public class DenseMatrix extends Matrix {
     private final int[][] rows;

     @Override
     public int numRows() {
         return rows.length;
     }

     @Override
     public int numCols() {
         return rows[0].length; // предполагаем, что все строки имеют одинаковую длину
     }

     @Override
     public int elem(int row, int col) {
         // предполагаем, что все индексы в допустимом диапазоне
         // иначе будет брошено ArrayIndexOutOfBoundsException
         return rows[row][col];
     }

     private DenseMatrix(int nRows, int nCol) {
         this.rows = new int[nRows][nCol];
     }
     private DenseMatrix(int[][] rows) {
         this.rows = rows;
     }

     /**
      * Создаёт матрицу (nRows x nCols) с нулевыми элементами
      */
     public static Matrix zeros(int nRows, int nCols) {
         return new DenseMatrix(nRows, nCols);
     }

     /** Создаёт матрицу с заказанными строками */
     public static DenseMatrix fromRows(int[][] rows) {
         return new DenseMatrix(rows);
     }

     /** Умножает текущую матрицу на вектор */
     @Override
     public int[] dotProduct(int[] vector) {
         int[] result = new int[numRows()];
         for (int iRow = 0; iRow < numRows(); iRow++) {
             int sum = 0;
             for (int iCol = 0; iCol < numCols(); iCol++) {
                 sum += rows[iRow][iCol] * vector[iCol];
             }
             result[iRow] = sum;
         }
         return result;
     }

     /**
      * Умножает текущую матрицу на другую матрицу.
      *
      * @param other другая матрица, количетсво строк которой должно быть равно
      *              количеству столбцов текущей матрицы
      * @retur новая матрица, являющаяся результатом умножения
      */
     @Override
     public Matrix multiply(Matrix other) {
         int nRows = numRows();
         int nCols = numCols();

         if (nCols != other.numRows())
             throw new IllegalArgumentException("Invalid matrix size");

         DenseMatrix result = new DenseMatrix(nRows, other.numCols());

         for (int iRow = 0; iRow < nRows; iRow++) {
             for (int iCol = 0; iCol < other.numCols(); iCol++) {
                 int sum = 0;
                 for (int k = 0; k < nCols; k++) {
                     sum += rows[iRow][k] * other.elem(k, iCol);
                 }
                 result.rows[iRow][iCol] = sum;
             }
         }
         return result;
     }

     @Override
     public DenseMatrix toDenseMatrix() { return this; }

     @Override
     public SparseMatrix toSparseMatrix() {
         return todo();
     }
}
