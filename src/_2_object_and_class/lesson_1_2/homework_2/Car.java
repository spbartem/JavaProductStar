package _2_object_and_class.lesson_1_2.homework_2;

public abstract class Car implements Driveable {
    private String name;
    private float hp;
    private int weight;
    private TypeCar typeCar;
    Wheel wheel;
    Engine engine;

    public Car(String name, float hp, int weight, TypeCar typeCar) {
        this.name = name;
        this.hp = hp;
        this.weight = weight;
        this.typeCar = typeCar;
        this.engine = new Engine();
        this.wheel = new Wheel();
    }

    @Override
    public String toString() {
        System.out.println("======================");
        return "Car{" +
                "name='" + this.name + '\'' +
                ", hp=" + hp +
                ", weight=" + weight +
                ", typeCar=" + typeCar +
                '}';
    }

    public void describeCar(){
        System.out.println("Name: " + getName() + "\n" +
                "Type: " + getTypeCar() + "\n" +
                "HP: " + getHp() + "\n" +
                "Weight: " + getWeight());
    }

    public String getName() {
        return name;
    }

    public float getHp() {
        return hp;
    }

    public int getWeight() {
        return weight;
    }

    public TypeCar getTypeCar() {
        return typeCar;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public Engine getEngine() {
        return engine;
    }

}
