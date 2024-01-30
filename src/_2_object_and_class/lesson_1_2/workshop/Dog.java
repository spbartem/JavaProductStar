package _2_object_and_class.lesson_1_2.workshop;

public class Dog extends Animal implements Walkable {

    public Dog(String say) {
        this.say = say;
        makeSound();
    }

    public void makeSound() {
        System.out.println("Bark!");
    }

    @Override
    public void walk() {
        System.out.println("Walk the dog");
    }
}
