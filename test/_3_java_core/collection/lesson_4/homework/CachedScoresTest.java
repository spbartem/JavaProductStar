package _3_java_core.collection.lesson_4.homework;

import _3_java_core.collection.lesson_4.homework.exception.StudentAndSubjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

class CachedScoresTest {
    private final MockExamination examination = new MockExamination();
    private final Examination cachedScores = new CachedScores(examination);

    @Test
    void quantityOfCalls() {
        cachedScores.getAverageForSubject("Algebra");
        cachedScores.getAverageForSubject("Biology");
        cachedScores.getAverageForSubject("Algebra");

        Assertions.assertEquals(2, examination.calls);

        cachedScores.getAverageForSubject("Geometry");
        Assertions.assertEquals(3, examination.calls);

        cachedScores.getAverageForSubject("Algebra");
        Assertions.assertEquals(3, examination.calls);

        cachedScores.getAverageForSubject("Biology");
        Assertions.assertEquals(4, examination.calls);

        cachedScores.getAverageForSubject("Geometry");
        Assertions.assertEquals(5, examination.calls);
    }

    private class MockExamination implements Examination {
        private int calls = 0;
        @Override
        public void addScore(Score score) {

        }

        @Override
        public Score getScore(String name, String subject) throws StudentAndSubjectNotFoundException {
            return null;
        }

        @Override
        public void addAllScore(List<Score> scores) {

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
            return null;
        }

        @Override
        public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
            return null;
        }

        @Override
        public Collection<Score> getAllScores() {
            calls++;
            Score score1 = new Score("John Smith", "Algebra", 5);
            Score score2 = new Score("Coal Adam", "Algebra", 3);
            Score score3 = new Score("Ivanov Andrey", "Algebra", 5);
            Score score4 = new Score("Ivanov Andrey", "Biology", 3);
            Score score5 = new Score("John Smith", "Biology", 3);
            Score score6 = new Score("Coal Adam", "Biology", 4);
            Score score7 = new Score("Ivanov Andrey", "Geometry", 3);
            Score score8 = new Score("John Smith", "Geometry", 3);
            Score score9 = new Score("Coal Adam", "Geometry", 4);

            return List.of(score1, score2, score3, score4, score5, score6, score7, score8, score9);
        }
    }
}