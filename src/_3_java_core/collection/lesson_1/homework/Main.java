package _3_java_core.collection.lesson_1.homework;

import java.util.Arrays;
import java.util.Random;

import static _3_java_core.collection.lesson_1.homework.BubbleSort.bubbleSort;
import static _3_java_core.collection.lesson_1.homework.InsertionSort.insertionSort;
import static _3_java_core.collection.lesson_1.homework.MergeSort.mergeSort;
import static _3_java_core.collection.lesson_1.homework.QuickSort.quickSort;
import static _3_java_core.collection.lesson_1.homework.SelectSort.selectSortAscending;

public class Main {

    public static void main(String[] args) {
        int arraySize = 12;
        int[] array = new int[arraySize];

        //время выполнения Arrays.sort, 3 замера, мс:
        //  1000 элементов: 1-0-0
        //  10000 элемнетов: 2-1-2
        //  100000 элементов: 9-9-12
        generateArray(array, arraySize);
        long startTime = System.currentTimeMillis();
        Arrays.sort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Arrays.sort time = " + (endTime - startTime));

        //время выполнения bubbleSort, 3 замера, мс:
        //  1000 элементов: 5-6-6
        //  10000 элемнетов: 164-165-170
        //  100000 элементов: 21326-19503-20011
        generateArray(array, arraySize);
        startTime = System.currentTimeMillis();
        bubbleSort(array);
        endTime = System.currentTimeMillis();
        System.out.println("Bubble sort from workshop time = " + (endTime - startTime));

        //время выполнения, 3 замера, мс:
        //  1000 элементов: 3-3-4
        //  10000 элемнетов: 49-53-47
        //  100000 элементов: 4112-4170-4059
        generateArray(array, arraySize);
        startTime = System.currentTimeMillis();
        selectSortAscending(array);
        endTime = System.currentTimeMillis();
        System.out.println("Select sort from workshop time = " + (endTime - startTime));

        //время выполнения, 3 замера, мс:
        //  1000 элементов: 3-3-3
        //  10000 элемнетов: 16-19-16
        //  100000 элементов: 960-920-914
        generateArray(array, arraySize);
        startTime = System.currentTimeMillis();
        insertionSort(array);
        endTime = System.currentTimeMillis();
        System.out.println("Insert sort from workshop time = " + (endTime - startTime));

        //время выполнения, 3 замера, мс:
        //  1000 элементов: 2-2-2
        //  10000 элемнетов: 4-6-4
        //  100000 элементов: 20-17-17
        generateArray(array, arraySize);
        startTime = System.currentTimeMillis();
        mergeSort(array);
        endTime = System.currentTimeMillis();
        System.out.println("Merge sort time = " + (endTime - startTime));

        //время выполнения, 3 замера, мс:
        //  1000 элементов: 1-1-1
        //  10000 элемнетов: 4-4-4
        //  100000 элементов: 87-80-80
        generateArray(array, arraySize);
        startTime = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Quick sort time = " + (endTime - startTime));
    }

    public static int[] generateArray(int[] array, int arrSize) {
        for (int i = 0; i < arrSize; i++) {
            array[i] = new Random().nextInt(100) + 300;
        }
        return array;
    }
}
