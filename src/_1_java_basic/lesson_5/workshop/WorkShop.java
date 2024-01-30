package _1_java_basic.lesson_5.workshop;

public class WorkShop {
    public static int solution(int[] input) {
        if (input.length == 0) {
            return -1;
        }

        int maxValue = input[0];
        int indexOfMaxValue = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] > maxValue) {
                maxValue = input[i];
                indexOfMaxValue = i;
            }
        }

        return indexOfMaxValue;
    }

    public static void equals(int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException("Wrong result");
        }
    }

    public static void test() {
        equals(solution(new int[]{1, 3, 2, 0}), 1);
        equals(solution(new int[]{1, 3, 2, 0, 3}), 1);
        equals(solution(new int[]{}), -1);

        equals(solution(new int[]{1, 2, 3, 4, 5}), 4);
    }

    public static void main(String[] args) {
        test();
        System.out.println("Tests passed");
    }
}
