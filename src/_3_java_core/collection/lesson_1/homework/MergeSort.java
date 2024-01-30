package _3_java_core.collection.lesson_1.homework;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,4};
        int[] b = new int[]{2,6,9,7};
//        System.out.println(Arrays.toString(merge(a, b)));
        System.out.println(Arrays.toString(sortMerge(new int[]{38, 27, 43, 3, 9, 82, 10})));
    }

    // сложность алгоритма O(log n);
    private static int[] sortMerge(int[] arr) {
        int len = arr.length;

        if (len < 2) {
            return arr;
        }

        int middle = len / 2;

        int[] firstPart = Arrays.copyOfRange(arr, 0, middle);
        int[] secondPart = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sortMerge(firstPart), sortMerge(secondPart));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int a = 0;
        int b = 0;

        int len = len1 + len2;

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len2 && a < len1) {
                if (arr1[a] > arr2[b]) {
                    result[i] = arr2[b++];
                } else {
                    result[i] = arr1[a++];
                }
            } else if (b < len2) {
                result[i] = arr2[b++];
            } else {
                result[i] = arr1[a++];
            }
        }
        return result;
    }
}
