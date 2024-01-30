package _2_object_and_class.lesson_7;

import java.util.Arrays;
import java.util.Scanner;
public class Calculator {

    public static Double[] resArr = new Double[3];
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.print("Введите 2 числа\n");

            double first = reader.nextDouble();
            double second = reader.nextDouble();

            System.out.print("Введите оператор: (+, -, *, /): ");
            char operator = reader.next().charAt(0);

            double result = 0.0;

            switch (operator) {
                case '+':
                    result = first + second;
                    break;

                case '-':
                    result = first - second;
                    break;

                case '*':
                    result = first * second;
                    break;

                case '/':
                    result = first / second;
                    break;

                default:
                    System.out.printf("Введите корректный оператор");
                    return;
            }
            System.out.printf("%.1f %c %.1f = %.1f\n", first, operator, second, result);

            boolean arrIsFull = true;

            for (int i = 0; i < resArr.length; i++) {
                if (resArr[i] == null) {
                    resArr[i] = result;
                    if (i != resArr.length - 1) {
                        arrIsFull = false;
                    }
                    break;
                }
            }

            if (arrIsFull == true) {
                System.out.println("Array of results is full. See results:");
                for (Double res : resArr) {
                    System.out.println(res);
                }
                return;
            }

            System.out.println("Если хотите завершить работу, введите *выход*\nДля продолжения введите любой символ...");
            String isExit = reader.next();
            if (isExit.equals("выход")) {
                break;
            }
        }
    }

    /*
     *     ДЗ
     *     1. добавьте массив для сохранения результатов размерностью 10
     *     если результатов стало больше мы завершаем работы, информируя пользователя и распечатывая результаты
     *
     *     2. поместите код в цикл для возможности использования без постоянного запуска программы.
     *     Для выхода пусть буду слова "выход"
     *     T.е. пользователь ввел выход - мы просто выходим, сохраняя результат в массиве результатов и выводим массив на консоль.
     *
     *
     */
}
