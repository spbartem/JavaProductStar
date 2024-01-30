package _2_object_and_class.lesson_7;

import java.util.Scanner;

import static _2_object_and_class.lesson_7.Person.*;

public class PhoneBook {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        initBD();
        
        while (true) {
            System.out.print("Для поиcка по имени введите 1, по номеру 2, email 3: ");
            String searchType = in.nextLine();

            System.out.print("Введите поисковое значение: ");
            String searchString = in.nextLine();

            System.out.println(findPerson(searchType, searchString, getPersons()));
            System.out.println("Если хотите завершить работу, введите *выход*\nДля продолжения введите любой символ...");
            String isExit = in.nextLine();
            if (isExit.equalsIgnoreCase("выход")) {
                break;
            }
        }
    }
}

class Person {
    private String name;
    private String phone;
    private String email;
    private static Person[] persons = new Person[10];

    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }


    String getName() {
        return name;
    }

    String getPhone() {
        return phone;
    }

    String getEmail() {
        return email;
    }

    public static Person[] getPersons() {
        return persons;
    }

    public static void initBD() {
        persons[0] = new Person("Юля", "89210000000", "Julia@yandex.com");
        persons[1] = new Person("Сергей", "777777", "borya@yandex.com");
        persons[2] = new Person("Друган", "23566777", "univer@yandex.com");
        persons[3] = new Person("EvilBoss", "456546546", "boss@yandex.com");
        persons[4] = new Person("Anna", "+79216661666", "mylove@yandex.com");
    }

    public String toString() {
        return "\n\nName: " + this.getName() + "\nPhone number: " + this.getPhone() + "\nEmail: " +
                this.getEmail();
    }

    // поиск человека
//    public static void findPerson(String searchType, String searchString) {
//
//        switch (searchType) {
//            case "1":
//                //по имени
//                System.out.println(findName(searchString, persons));
//                break;
//            case "2":
//                //по телефону
//                break;
//            case "3":
//                // по почте
//                break;
//            default:
//                break;
//        }
//    }

    public static void printEmptyException(String info) {
        if (info.isEmpty()) {
            System.out.println("Поиск по пустому значению невозможен.");
            System.exit(0);
        }
    }

    public static Person findPerson(String searchType, String searchString, Person[] persons) {
        for (Person person : persons) {
            printEmptyException(searchString);
            if (person == null) continue;
            switch (searchType) {
                case "1":
                    if (person.getName().equals(searchString)) {
                        return person;
                    }
                    break;
                case "2":
                    if (person.getPhone().equals(searchString)) {
                        return person;
                    }
                    break;
                case "3":
                    if (person.getEmail().equals(searchString)) {
                        return person;
                    }
                    break;
            }

        }
        System.out.println("нет такого человека");
        return null;
    }
}

/*
 ДЗ
Дописать методы поиска для телефона и почты
Сделать так же выход
Продумать обработку исключений для поиска по пустым значениям
*/
