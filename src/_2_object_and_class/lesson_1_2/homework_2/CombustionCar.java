package _2_object_and_class.lesson_1_2.homework_2;

public class CombustionCar extends Car {

    public CombustionCar(String name, float hp, int weight, TypeCar typeCar) {
        super(name, hp, weight, typeCar);
    }

    @Override
    public void drive() {
        getEngine().startEngine();
        getWheel().steerTheWheel();
        getEngine().stopEngine();
    }
}
