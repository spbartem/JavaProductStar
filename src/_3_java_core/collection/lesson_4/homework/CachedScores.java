package _3_java_core.collection.lesson_4.homework;

import _3_java_core.collection.lesson_4.homework.exception.StudentAndSubjectNotFoundException;

import java.util.*;

public class CachedScores implements Examination {

    Map<String, Double> cachedScores = new LRUCache<>(2);

    private final Examination examination;

    public CachedScores(Examination examination) {
        this.examination = examination;
    }

    @Override
    public void addScore(Score score) {
        examination.addScore(score);
    }

    @Override
    public Score getScore(String name, String subject) throws StudentAndSubjectNotFoundException {
        return examination.getScore(name, subject);
    }

    @Override
    public void addAllScore(List<Score> scores) {
        examination.addAllScore(scores);
    }

    @Override
    public double getAverageForSubject(String subject) {
        return cachedScores.computeIfAbsent(subject, examination::getAverageForSubject);
    }

    @Override
    public Set<String> multipleSubmissionsStudentNames() {
        return examination.multipleSubmissionsStudentNames();
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        return examination.lastFiveStudentsWithExcellentMarkOnAnySubject();
    }

    @Override
    public Collection<Score> getAllScores() {
        return examination.getAllScores();
    }

    class LRUCache<KEY, VALUE> extends LinkedHashMap<KEY, VALUE> {
        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<KEY, VALUE> eldest) {
            return size() > capacity;
        }
    }
}
