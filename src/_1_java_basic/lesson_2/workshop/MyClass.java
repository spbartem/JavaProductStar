package _1_java_basic.lesson_2.workshop;

import java.util.Scanner;

public class MyClass {

    public static void main(String[] params) {
        System.out.println("Введите возраст: ");

        Scanner in = new Scanner(System.in);
        String age = in.nextLine();

        System.out.println("Ваш возраст " + age + " лет");

        System.out.println("Введите пол:");
        String gender = in.nextLine();
        if (gender.equals("м")) {
            System.out.println("Вы мужчина");
        } else if (gender.equals("ж")) {
            System.out.println("Вы женщина");
        } else {
            System.out.println("Пол не определён");
        }
    }
}
