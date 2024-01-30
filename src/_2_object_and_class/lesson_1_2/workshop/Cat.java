package _2_object_and_class.lesson_1_2.workshop;

public class Cat extends Animal implements Walkable, Scratchable, Fightable {

    public Cat(int lives) {
        super(lives);
        System.out.println("Cat constructor called");
        this.lives = 9;
        System.out.println("Cat has " + this.lives + " lives");
    }

    public void mew() {
        System.out.println("Mew!");
    }

    public void makeSound() {
        System.out.println("Mew!");
    }

    @Override
    public void scratch() {
        System.out.println("Scratch!!!");
    }

    @Override
    public void walk() {
        System.out.println("Walk the cat");
    }

    @Override
    public void bite() {
        System.out.printf("BITEEE");
    }
}
