package _3_java_core.collection.lesson_1.homework;

import java.util.Arrays;

public class BubbleSort {
    //сложность алгоритма O(n^2)
    public static int[] bubbleSortOld(int[] arr) {
        int len = arr.length;
        boolean complete;
        do {
            complete = true;
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int previousNumber = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = previousNumber;
                    complete = false;
                }
            }
        } while (!complete);
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }
}
