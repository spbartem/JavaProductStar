package _2_object_and_class.lesson_1_2.homework_1;

public class Docent extends Human {

    @Override
    public void sayHi() {
        System.out.println("Hi! I'm a strict docent " + name);
    }

    public void makeMyLifeHell() {
        System.out.println("All students must suffer!");
    }
}
