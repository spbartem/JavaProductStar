package _3_java_core.collection.lesson_2.homework;

import java.util.*;

/*
Задание 2: Реализуй метод, в котором создаются ArrayList, LinkedList и заполняются 1 000 000 случайными элементами
одного и того же типа. После из ArrayList и LinkedList 1000 раз выбираем элемент по случайному индексу.
Замерь время для ArrayList и LinkedList.
Сравни результаты и предположи, почему они могут отличаться.
*/

/*
Доступ к элементу по индексу в ArrayList занимает константное время O(1),
в то время как для доступа к элементу в LinkedList необходимо проитерироваться по каждому элементу до искомого O(n)
*/

public class Task2 {
    public static final Random random = new Random();
    static List<Integer> arrayList = new ArrayList<>();
    static List<Integer> linkedList = new LinkedList<>();
    public static final Integer COUNT_TO_SELECT = 7000;

    public static void main(String[] args) {
        fillLists();
        selectElement(arrayList);
        selectElement(linkedList);
    }

    public static void fillLists() {
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(random.nextInt());
            linkedList.add(random.nextInt());
        }
    }

    public static void selectElement(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT_TO_SELECT; i++) {
            list.get(random.nextInt(list.size()));
        }
        System.out.println("Selected " + COUNT_TO_SELECT + " times an element from the " +
                list.getClass().getSimpleName() + " for: "
                + (System.currentTimeMillis() - startTime) + " ms");
    }
}
