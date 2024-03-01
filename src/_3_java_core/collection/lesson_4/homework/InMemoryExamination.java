package _3_java_core.collection.lesson_4.homework;

import _3_java_core.collection.lesson_4.homework.exception.StudentAndSubjectNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryExamination implements Examination {
    private static final int INITIAL_CAPACITY = 128;
    private final Map<String, Score> allScores = new LinkedHashMap<>(INITIAL_CAPACITY);

    @Override
    public void addScore(Score score) {
        allScores.put(score.name() + score.subject(), score);
    }

    @Override
    public Score getScore(String name, String subject) throws StudentAndSubjectNotFoundException {
        Score score = allScores.get(name+subject);
        if (score == null) {
            throw new StudentAndSubjectNotFoundException("The \"Student + Subject\" pair was not found: " + name + " + " + subject);
        }
        return score;
    }

    @Override
    public void addAllScore(List<Score> scores) {
        for (Score score : scores) {
            allScores.put(score.name() + score.subject(), score);
        }
    }

    @Override
    public double getAverageForSubject(String subject) {
        Collection<Score> allExaminations = getAllScores();
        double averageForSubject = 0.0;
        int quantity = 0;
        for (Score score : allExaminations) {
            if (score.subject().equals(subject)) {
                averageForSubject = averageForSubject + score.score();
                quantity++;
            }
        }
        return Math.floor((averageForSubject/quantity) * 100) / 100;
    }

    @Override
    public Set<String> multipleSubmissionsStudentNames() {
        Map<String, Integer> studentNames = new HashMap<>();
        for (Score score : allScores.values()) {
            Integer aggregation = studentNames.getOrDefault(score.name(), 0);
            aggregation++;
            studentNames.put(score.name(), aggregation);
        }
        return studentNames.entrySet().stream()
                .filter(v -> v.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        Set<String> studentsWithExcellentMark = new LinkedHashSet<>();
        int countOfStudents = 1;
        ListIterator<Map.Entry<String, Score>> iterator = new ArrayList<>(allScores.entrySet())
                .listIterator(allScores.size());

        while (iterator.hasPrevious() && countOfStudents <= 5) {
            Map.Entry<String, Score> entry = iterator.previous();
            if (entry.getValue().score() == 5) {
                studentsWithExcellentMark.add(entry.getValue().name());
                countOfStudents++;
            }
        }
        return studentsWithExcellentMark;
    }

    @Override
    public Collection<Score> getAllScores() {
        return new ArrayList<>(allScores.entrySet().stream().map(Map.Entry::getValue).toList());
    }
}
