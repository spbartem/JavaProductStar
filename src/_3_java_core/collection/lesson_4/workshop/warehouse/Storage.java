package _3_java_core.collection.lesson_4.workshop.warehouse;

import _3_java_core.collection.lesson_4.workshop.warehouse.exceptions.ItemNotFoundException;

import java.util.List;

public interface Storage {
    void putItem(Wheel wheel);

    Wheel getItem(String id) throws ItemNotFoundException;

    boolean containsItem(String id);

    Wheel removeItem(String id) throws ItemNotFoundException;

    void putAllItems(List<Wheel> items);
}
