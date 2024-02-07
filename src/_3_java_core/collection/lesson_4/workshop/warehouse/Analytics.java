package _3_java_core.collection.lesson_4.workshop.warehouse;

import java.util.Map;
import java.util.Set;

record CategoryAndPlace(String category, String place) {
}
public interface Analytics {
    Set<String> getCategories();

    Map<CategoryAndPlace, Integer> getAggregationByCategoriesAndPlace();

    Integer getTotalCount();
}
