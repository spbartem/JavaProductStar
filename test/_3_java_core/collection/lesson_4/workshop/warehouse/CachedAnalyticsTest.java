package _3_java_core.collection.lesson_4.workshop.warehouse;

import _3_java_core.collection.lesson_4.workshop.warehouse.exceptions.ItemNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class CachedAnalyticsTest {
    private final MockStorage storage = new MockStorage();

    private final Analytics analytics = new CachedAnalytics(new BasicAnalytics(storage));

    @Test
    void callOnceForRepeatingRequests() {
        CategoryAndPlace request1 = new CategoryAndPlace("winter", "A");
        CategoryAndPlace request2 = new CategoryAndPlace("winter", "B");
        CategoryAndPlace request3 = new CategoryAndPlace("summer", "A");

        // Integer aggregationByCategoriesAndPlace = analytics.getAggregationByCategoryAndPlace(request1);
        // Assertions.assertEquals(10, aggregationByCategoriesAndPlace);

        analytics.getAggregationByCategoryAndPlace(request1);
        analytics.getAggregationByCategoryAndPlace(request2);
        analytics.getAggregationByCategoryAndPlace(request1);

        Assertions.assertEquals(2, storage.calls);

        analytics.getAggregationByCategoryAndPlace(request3);
        Assertions.assertEquals(3, storage.calls);

        analytics.getAggregationByCategoryAndPlace(request1);
        Assertions.assertEquals(3, storage.calls);

        analytics.getAggregationByCategoryAndPlace(request2);
        Assertions.assertEquals(4, storage.calls);

    }

    private class MockStorage implements Storage {
        private int calls = 0;
        @Override
        public void putItem(Wheel wheel) {

        }

        @Override
        public Wheel getItem(String id) throws ItemNotFoundException {
            return null;
        }

        @Override
        public boolean containsItem(String id) {
            return false;
        }

        @Override
        public Wheel removeItem(String id) throws ItemNotFoundException {
            return null;
        }

        @Override
        public void putAllItems(List<Wheel> items) {

        }

        @Override
        public Map<String, Wheel> getAllItems() {
            calls++;
            Wheel wheel = new Wheel("1", "hallapelita", "summer", "A", 5);
            Wheel winter = new Wheel("2", "hallapelita", "winter", "A", 5);
            Wheel winter2 = new Wheel("21", "hallapelita", "winter", "A", 5);
            Wheel winter3 = new Wheel("22", "hallapelita", "winter", "B", 5);
            Wheel allSeason = new Wheel("3", "hallapelita", "allSeason", "A", 5);

            return Map.of(wheel.id(), wheel, winter.id(), winter,  winter2.id(), winter2,  winter3.id(), winter3, allSeason.id(), allSeason);
        }

        @Override
        public List<Wheel> getAllItemsSorted(Predicate<Wheel> predicate) {
            return null;
        }
    }
}

