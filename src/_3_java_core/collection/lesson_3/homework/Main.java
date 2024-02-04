package _3_java_core.collection.lesson_3.homework;

/*
    Дан непустой массив целых чисел длиной n и число k (0 < k <= n).
    Нужно вывести среднее значение для всех подмассивов длиной k, входящих в исходный массив.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 10));
        int k = 2;

        getRollingAverage(arr, k);
    }

    private static void getRollingAverage(ArrayList<Integer> arr, int k) {
        LinkedList<Integer> subArr = new LinkedList<>();
        ArrayList<Double> resArray = new ArrayList<>();
        Double sumSubArrElements = 0.0;

        for (int i = 0; i < k; i++) {
            subArr.add(arr.get(i));
            sumSubArrElements += arr.get(i);
        }

        resArray.add(sumSubArrElements / k);

        for (int i = k; i < arr.size(); i++) {
            subArr.add(arr.get(i));
            subArr.remove();

            sumSubArrElements = subArr.stream().mapToDouble(Double::valueOf).sum();

/*
            sumSubArrElements = 0.0;
            for (int elSubArr : subArr) {
                sumSubArrElements += elSubArr;
            }
*/

            resArray.add(sumSubArrElements / k);
        }

        System.out.println(resArray);
    }
}
