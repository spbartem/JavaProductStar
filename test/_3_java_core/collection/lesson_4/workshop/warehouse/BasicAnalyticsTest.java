package _3_java_core.collection.lesson_4.workshop.warehouse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

class BasicAnalyticsTest {

    private Analytics analytics;
    private Storage storage;

    @BeforeEach
    void setUp() {
        storage = new InMemoryStorage();
        analytics = new BasicAnalytics(storage);
    }

    @Test
    void getCategories() {
        Wheel wheel = new Wheel("1", "hallapelita", "summer", "A", 5);
        Wheel winter = new Wheel("2", "hallapelita", "winter", "A", 5);
        Wheel winter2 = new Wheel("21", "hallapelita", "winter", "A", 5);
        Wheel winter3 = new Wheel("22", "hallapelita", "allSeason", "A", 5);
        Wheel allSeason = new Wheel("3", "hallapelita", "allSeason", "A", 5);
        storage.putAllItems(List.of(wheel, winter, winter2, winter3, allSeason));

        Set<String> categories = analytics.getCategories();

        Assertions.assertEquals(3, categories.size());
        Assertions.assertTrue(categories.contains("winter"));
        Assertions.assertTrue(categories.contains("summer"));
        Assertions.assertTrue(categories.contains("allSeason"));
    }

    @Test
    void getAggregationByCategoriesAndPlace() {
        Wheel wheel = new Wheel("1", "hallapelita", "summer", "A", 5);
        Wheel winter = new Wheel("2", "hallapelita", "winter", "A", 5);
        Wheel winter2 = new Wheel("21", "hallapelita", "winter", "A", 5);
        Wheel winter3 = new Wheel("22", "hallapelita", "winter", "B", 5);
        Wheel allSeason = new Wheel("3", "hallapelita", "allSeason", "A", 5);
        storage.putAllItems(List.of(wheel, winter, winter2, winter3, allSeason));

        Map<CategoryAndPlace, Integer> aggregationByCategoriesAndPlace =
                analytics.getAggregationByCategoryAndPlace();

        Assertions.assertEquals(10, aggregationByCategoriesAndPlace.get(new CategoryAndPlace("winter", "A")));
    }

    @Test
    void getAggregationByCategoriesAndPlaceSingleRequest() {
        Wheel wheel = new Wheel("1", "hallapelita", "summer", "A", 5);
        Wheel winter = new Wheel("2", "hallapelita", "winter", "A", 5);
        Wheel winter2 = new Wheel("21", "hallapelita", "winter", "A", 5);
        Wheel winter3 = new Wheel("22", "hallapelita", "winter", "B", 5);
        Wheel allSeason = new Wheel("3", "hallapelita", "allSeason", "A", 5);
        storage.putAllItems(List.of(wheel, winter, winter2, winter3, allSeason));

        Integer quantity = analytics.getAggregationByCategoryAndPlace(new CategoryAndPlace("winter", "A"));

        Assertions.assertEquals(10, quantity);
    }

    @Test
    void getTotalCount() {
        Wheel wheel = new Wheel("1", "hallapelita", "summer", "A", 5);
        Wheel winter = new Wheel("2", "hallapelita", "winter", "A", 5);
        Wheel winter2 = new Wheel("21", "hallapelita", "winter", "A", 5);
        Wheel winter3 = new Wheel("22", "hallapelita", "allSeason", "A", 5);
        Wheel allSeason = new Wheel("3", "hallapelita", "allSeason", "A", 5);
        storage.putAllItems(List.of(wheel, winter, winter2, winter3, allSeason));

        Integer totalCount = analytics.getTotalCount();

        Assertions.assertEquals(25, totalCount);
    }
}