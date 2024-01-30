package _2_object_and_class.lesson_1_2.workshop;

public abstract class Animal {
    private int age;
    Color color;
    boolean gender;
    private String name;
    protected int lives;
    protected String say;

    public abstract void makeSound();

    public Animal() {
    }

    public Animal(int lives) {
        System.out.println("Animal constructor called");
        this.lives = lives;
        System.out.println("Animal has " + this.lives + " lives");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age is negative!");
        }
        this.age = Math.max(0, age);
    }

    public String getName() {
        if (name == null) {
            return "Unnamed";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void jump() {
        System.out.println("Jump!");
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
