package _2_object_and_class.lesson_5.workshop;

import java.util.Arrays;

public class App {
    /*
    Библиотека матричных операций
    - Постановка задачи
    - Основные операции
    - Представление плотных матриц
    - Представление разреженных матриц
    - Операции над плотными матрицами
    - Операции над разреженными матрицами
    */
    static void run(String title, Matrix A, Matrix B, int[] v) {
        System.out.println("========== " + title + " ==========");
        System.out.println("Matrix A:");
        System.out.println(A);

        System.out.println("Matrix B:");
        System.out.println(B);

        System.out.println("Vector v: " + Arrays.toString(v));

        int[] r = A.dotProduct(v);
        System.out.println("Vector A * v:");
        System.out.println(Arrays.toString(r));

        // Умножение матриц A и B
        Matrix E = A.multiply(B);
        System.out.println("Matrix A * B");
        System.out.println(E.toString());
    }

    public static void main(String[] args) {
        int[][] elemsA = new int[][]{
                {1, 2},
                {3, 4}
        };
        int[][] elemsB = new int[][]{
                {2, 0},
                {1, 2}
        };
        int[] v = {1, 2};

        {
            // Создание матрицы A 2х2
            Matrix A = DenseMatrix.fromRows(elemsA);

            // Создание матрицы B 2х2
            Matrix B = DenseMatrix.fromRows(elemsB);

            run("DenseMatrix", A, B, v);
        }

        {
            // Создание матрицы A 2х2
            Matrix A = SparseMatrix.fromRows(elemsA);

            // Создание матрицы B 2х2
            Matrix B = SparseMatrix.fromRows(elemsA);

            run("SparseMatrix", A, B, v);
        }
    }
}
