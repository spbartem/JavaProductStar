package _3_java_core.collection.lesson_1.homework;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort(new int[]{44, 77, 122, 4, 11, 3, 17, 54, 33, 2, 7, 8, 1, 15, 6, 7, 9, 12});
    }
    //сложность алгоритма O(n^2)
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        int cnt = 0;
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
            cnt++;
        } while (!complete);
        System.out.println(Arrays.toString(arr) + " " + cnt);
    }
}
