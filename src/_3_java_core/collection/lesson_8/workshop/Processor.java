package _3_java_core.collection.lesson_8.workshop;

public class Processor<T extends Person> {
    private T object;

    public Processor(T object) {
        this.object = object;
    }

    public void process() {
        object.saySomething();
    }

    public T getObject() {
        return object;
    }
}
