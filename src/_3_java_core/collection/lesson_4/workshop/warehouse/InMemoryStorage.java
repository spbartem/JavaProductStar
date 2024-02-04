package _3_java_core.collection.lesson_4.workshop.warehouse;

import _3_java_core.collection.lesson_4.workshop.warehouse.exceptions.ItemNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStorage implements Storage {

    public static final int INITIAL_CAPACITY = 256;

    private final Map<String, Wheel> items = new HashMap<>(INITIAL_CAPACITY);
    @Override
    public void putItem(Wheel wheel) {
        items.put(wheel.id(), wheel);
    }

    @Override
    public Wheel getItem(String id) throws ItemNotFoundException {
        Wheel wheel = items.get(id);
        if (wheel == null) {
            throw new ItemNotFoundException(id);
        }
        return items.get(id);
    }

    @Override
    public void containsItem(String id) {

    }

    @Override
    public Wheel removeItem(String id) {
        return null;
    }
}
