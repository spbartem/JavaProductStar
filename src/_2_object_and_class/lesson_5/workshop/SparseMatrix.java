package _2_object_and_class.lesson_5.workshop;

import java.util.Arrays;

 /**
 * Представляет разреженную матрицу в формате CRS, где каждая строка представлена
 * двумя массивами одинаковой длины:
 * - массивы индексов столбцов, где находятся ненулевые значения
 * - массивы значений для каждого столбца
 */

public class SparseMatrix extends Matrix {
     /** Количество столбцов в матрице. */
     private int nCols;

     /**
      * Индексы для формата матрицы CRS, один массив для каждой строки.
      * Индексы столбцов должны быть отсортированы в порядке возрастания.
      */
     private int[][] indices;

     /** Значения для формата матрицы CRS, один массив для каждой строки */
     private int[][] values;

     public SparseMatrix(int nCols, int[][] indices, int[][] values) {
         this.nCols = nCols;
         this.indices = indices;
         this.values = values;
     }

     @Override
     public int numRows() {
         return indices.length;
     }

     @Override
     public int numCols() {
         return nCols;
     }

     private static int countNonZeroElems(int[] row) {
         int nonZeroCount = 0;
         for (int j = 0; j < row.length; j++) {
             if (row[j] != 0) {
                 nonZeroCount++;
             }
         }
         return nonZeroCount;
     }

     public static Matrix zeros(int nRows, int nCols) {
         return new SparseMatrix(nCols, new int[nRows][0], new int[nRows][0]);
     }

     /** Creates matrix from rows. */
     public static Matrix fromRows(int[][] rows) {
         int nCols = rows[0].length;
         for (int i = 1; i < rows.length; i++) {
             if (rows[i].length != nCols) {
                 throw new IllegalArgumentException("Все строки должны иметь одинаковую длину.");
             }
         }

         int[][] indices = new int[rows.length][];
         int[][] values = new int[rows.length][];

         for (int iRow = 0; iRow < rows.length; iRow++) {
             int[] row = rows[iRow];
             int nonZeroCount = countNonZeroElems(row);
             indices[iRow] = new int[nonZeroCount];
             values[iRow] = new int[nonZeroCount];
             int k = 0;
             for (int iCol = 0; iCol < row.length; iCol++) {
                 if (row[iCol] != 0) {
                     indices[iRow][k] = iCol;
                     values[iRow][k] = row[iCol];
                     k++;
                 }
             }
         }

         return new SparseMatrix(nCols, indices, values);
     }

     @Override
     public int elem(int row, int col) {
         int idx = Arrays.binarySearch(indices[row], col);
         if (idx < 0) {
             return 0;
         }
         return values[row][idx];
     }

     @Override
     public int[] dotProduct(int[] vector) {
         int[] result = new int[numRows()];
         for (int iRow = 0; iRow < numRows(); iRow++) {
             int sum = 0;
             for (int j = 0; j < indices[iRow].length; j++) {
                 int iCol = indices[iRow][j];
                 sum += values[iRow][j] * vector[iCol];
             }
             result[iRow] = sum;
         }
         return result;
     }

     @Override
     public Matrix multiply(Matrix other) {
         int nRows = numRows();
         int[][] resultRows = new int[nRows][];
         for (int iRow = 0; iRow < nRows; iRow++) {
             resultRows[iRow] = new int[other.numCols()];
             for (int iCol = 0; iCol < other.numCols(); iCol++) {
                 int sum = 0;
                 for (int j = 0; j < indices[iRow].length; j++) {
                     int k = indices[iRow][j];
                     sum += values[iRow][j] * other.elem(k, iCol);
                 }
                 resultRows[iRow][iCol] = sum;
             }
         }
         return fromRows(resultRows);
     }

     @Override
     public DenseMatrix toDenseMatrix() {
         return null;
     }

     @Override
     public SparseMatrix toSparseMatrix() {
         return null;
     }
}
