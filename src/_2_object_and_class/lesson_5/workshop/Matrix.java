package _2_object_and_class.lesson_5.workshop;

public abstract class Matrix {
    static <T> T todo() {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    /** Number of rows in this matrix. */
    public abstract int numRows();

    /** Number of columns in this matrix. */
    public abstract int numCols();

    /** Return value of matrix element at 'row' and 'col'. */
    public abstract int elem(int row, int col);

    public abstract int[] dotProduct(int[] vector);

    /**
     * Умножает текущую матрицу на другую матрицу.
     *
     * @param other другая матрица, количество строк которой должно быть равно
     *              количеству столбцов текущей матрицы
     * @return новая матрица, являющаяся результатом умножения
     */
    public abstract Matrix multiply(Matrix other);

    @Override
    public String toString() {
        int nCols = numCols(); int nRows = numRows();
        int[] colWidths = new int[nCols];
        for (int col = 0; col < nCols; col++) {
            int maxWidth = 0;
            for (int row = 0; row < nRows; row++) {
                int width = Integer.toString(elem(row, col)).length();
                maxWidth = Math.max(maxWidth, width);
            }
            colWidths[col] = maxWidth;
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                String cell = String.format("%" + colWidths[col] + "d", elem(row, col));
                sb.append(cell);
                if (col < nCols - 1) {
                    sb.append(" ");
                }
            }
            if (row < nRows - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public abstract DenseMatrix toDenseMatrix();
    public abstract SparseMatrix toSparseMatrix();
}
