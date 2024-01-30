package _3_java_core.collection.lesson_1.workshop;

import java.util.Arrays;
import java.util.Random;

import static _3_java_core.collection.lesson_1.workshop.BubbleSort.bubbleSort;
import static _3_java_core.collection.lesson_1.workshop.InsertionSort.insertionSort;
import static _3_java_core.collection.lesson_1.workshop.SelectSort.selectSortAscending;

public class Main {
    public static void main(String[] args) {
        int arraySize = 1000;
        int[] array = new int[arraySize];
        generate(array, arraySize);
        long startTime = System.currentTimeMillis();
        Arrays.sort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Arrays.sort time =" + (endTime - startTime));

        generate(array, arraySize);
        startTime = System.currentTimeMillis();
        bubbleSort(array);
        endTime = System.currentTimeMillis();
        System.out.println("Bubble sort time =" + (endTime - startTime));

        generate(array, arraySize);
        startTime = System.currentTimeMillis();
        insertionSort(array);
        endTime = System.currentTimeMillis();
        System.out.println("Insert sort time =" + (endTime - startTime));

        generate(array, arraySize);
        startTime = System.currentTimeMillis();
        selectSortAscending(array);
        endTime = System.currentTimeMillis();
        System.out.println("Select sort time =" + (endTime - startTime));
    }

    public static int[] generate(int[] array, int arrSize) {
        for (int i = 0; i < arrSize; i++) {
            array[i] = new Random().nextInt(100) + 300;
        }
        return array;
    }
}