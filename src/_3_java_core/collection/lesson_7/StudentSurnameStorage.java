package _3_java_core.collection.lesson_7;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentSurnameStorage {
    private TreeMap<String, Set<Long>> surnamesTreeMap = new TreeMap<>();

    public void studentCreated(Long id, String surname) {
        Set<Long> existingIds = surnamesTreeMap.getOrDefault(surname, new HashSet<>());
        existingIds.add(id);
        surnamesTreeMap.put(surname, existingIds);
    }

    public void studentDeleted(Long id, String surname) {
        surnamesTreeMap.get(surname).remove(id);
    }

    public void studentUpdated(Long id, String oldSurname, String newSurname) {
        studentDeleted(id, oldSurname);
        studentCreated(id, newSurname);
    }

    public Set<Long> getStudentIdsBySurname(String surname) {
        Set<Long> res = surnamesTreeMap.get(surname);
        return res;
    }

    public TreeMap<String, Set<Long>> getSurnamesTreeMap() {
        return new TreeMap<>(surnamesTreeMap);
    }

    /**
     * Данный метод возвращает уникальные идентификаторы студентов,
     * чьи фамилии меньше или равны переданной.
     * @return
     */

    public Set<Long> getStudentBySurnamesLessOrEqualsThan(String surname) {
        Set<Long> res = surnamesTreeMap.headMap(surname, true)
                .values()
                .stream()
                .flatMap(longs -> longs.stream())
                .collect(Collectors.toSet());
        return res;
    }

    public Set<Long> getStudentBySurnamesBetween(String surnameFrom, String surnameTo) {
        Set<Long> res = surnamesTreeMap.subMap(surnameFrom, true, surnameTo, true)
                .values()
                .stream()
                .flatMap(longs -> longs.stream())
                .collect(Collectors.toSet());
        return res;
    }
}
