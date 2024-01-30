package _2_object_and_class.lesson_1_2.homework_2;

public class ElectricCar extends Car {
    public ElectricCar(String name, float hp, int weight, TypeCar typeCar) {
        super(name, hp, weight, typeCar);
    }

    @Override
    public void drive() {
        getWheel().steerTheWheel();
    }
}
