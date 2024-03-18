package _3_java_core.collection.lesson_8.workshop;

public class CarWrapper {
    private int price;
    private Car car;

    public CarWrapper(int price, Car car) {
        this.price = price;
        this.car = car;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
