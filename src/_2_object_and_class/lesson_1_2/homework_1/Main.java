package _2_object_and_class.lesson_1_2.homework_1;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();

        Docent docent = new Docent();
        docent.name = "Sam";

        getTogether(student, docent);
    }

    public static void getTogether(Human human1, Human human2) {
        human1.sayHi();
        human2.sayHi();
    }
}
