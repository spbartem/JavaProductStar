package _1_java_basic.lesson_4.homework;

public class Main {

    public static void main(String[] args) {
        int n = 33;
        for (int i = 0; i <= n; i++) {

            if (i == 0) {
                System.out.print(i);
            } else if (i % 3 == 0 & i % 5 == 0) {
                System.out.print(" fizzbuzz");
            } else if (i % 5 == 0) {
                System.out.print(" buzz");
            } else if (i % 3 == 0) {
                System.out.print(" fizz");
            } else {
                System.out.print(" " + i);
            }

        }

    }
}
