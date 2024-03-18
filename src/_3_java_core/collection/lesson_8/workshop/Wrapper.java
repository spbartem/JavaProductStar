package _3_java_core.collection.lesson_8.workshop;

public class Wrapper<T> {
    private int price;
    private T object;

    public Wrapper(int price, T object) {
        this.price = price;
        this.object = object;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
