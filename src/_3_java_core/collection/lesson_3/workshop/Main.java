package _3_java_core.collection.lesson_3.workshop;

/*
    Дан массив целых чисел длиной n и число k
    Нужно вывести все подмассивы длиной k, входящих в исходный массив
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        int k = 2;

        printSubArray(arr, k);

    }

    private static void printSubArray(ArrayList<Integer> arr, int k) {
        LinkedList<Integer> subList = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            subList.add(arr.get(i));
        }

        System.out.println(subList);

        for (int i = k; i < arr.size(); i++) {
            subList.add(arr.get(i));
            subList.remove();
            System.out.println(subList);
        }
    }
}
