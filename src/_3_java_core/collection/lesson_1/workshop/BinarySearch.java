package _3_java_core.collection.lesson_1.workshop;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    static int iteration = 0;

    public static void main(String[] args) {
        int arraySize = 1000;
        int[] array = new int[arraySize];
        generate(array, arraySize);
        Arrays.sort(array);
        int result = binarySearch(array, 313, 0, array.length - 1);
        System.out.println(result);
        result = Arrays.binarySearch(array, 3134);
        System.out.println(result);
    }

    public static int[] generate(int[] array, int arrSize) {
        for (int i = 0; i < arrSize; i++) {
            array[i] = new Random().nextInt(100) + 300;
        }
        return array;
    }

    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        System.out.println(iteration++);
        int middle = low + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return binarySearch(sortedArray, key, low, middle - 1);
        } else {
            return binarySearch(sortedArray, key, middle, high);
        }
    }
}
