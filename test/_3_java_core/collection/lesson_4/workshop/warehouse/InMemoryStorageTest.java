package _3_java_core.collection.lesson_4.workshop.warehouse;

import _3_java_core.collection.lesson_4.workshop.warehouse.exceptions.ItemNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryStorageTest {

    private Storage storage;

    @BeforeEach
    void setUp() {
        storage = new InMemoryStorage();
    }

    @Test
    void putItem() throws ItemNotFoundException {
        Wheel wheel = new Wheel(UUID.randomUUID().toString(), "hakkapelita", "winter", "A", 10);

        storage.putItem(wheel);

        Wheel actual = storage.getItem(wheel.id());
        Assertions.assertEquals(wheel, actual);
    }

    @Test
    void getItem() {
        Assertions.assertThrows(ItemNotFoundException.class, () -> storage.getItem("123"));
    }

    @Test
    void containsItem() {
        Wheel wheel1 = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel wheel2 = new Wheel("2", "hakkapelita", "winter", "A", 10);
        Wheel wheel3 = new Wheel("3", "hakkapelita", "summer", "A", 10);

        storage.putItem(wheel1);
        storage.putItem(wheel3);

        Assertions.assertTrue(storage.containsItem("1"));
        Assertions.assertTrue(storage.containsItem("3"));
        Assertions.assertFalse(storage.containsItem("2"));
    }

    @Test
    void removeItem() throws ItemNotFoundException {
        Wheel wheel1 = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel wheel3 = new Wheel("3", "hakkapelita", "summer", "A", 10);
        storage.putItem(wheel1);
        storage.putItem(wheel3);

        Wheel removeItem = storage.removeItem("1");

        Assertions.assertTrue(storage.containsItem("3"));
        Assertions.assertFalse(storage.containsItem("1"));
        Assertions.assertEquals(removeItem, wheel1);

        Assertions.assertThrows(ItemNotFoundException.class, () -> storage.removeItem("2"));
    }

    @Test
    void addListOfItems() {
        Wheel wheel1 = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel wheel2 = new Wheel("2", "hakkapelita", "winter", "B", 10);
        Wheel wheel3 = new Wheel("3", "hakkapelita", "summer", "A", 10);

        storage.putAllItems(List.of(wheel1, wheel2, wheel3));

        Assertions.assertTrue(storage.containsItem("3"));
        Assertions.assertTrue(storage.containsItem("2"));
        Assertions.assertTrue(storage.containsItem("1"));
    }
}