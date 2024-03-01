package _3_java_core.collection.lesson_4.homework;

import _3_java_core.collection.lesson_4.homework.exception.StudentAndSubjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class InMemoryExaminationTest {

    private Examination examinations;

    @BeforeEach
    void setUp() { examinations = new InMemoryExamination(); }

    @Test
    void addScore() throws StudentAndSubjectNotFoundException {
        Score score1 = new Score("Ivanov Andrey", "Biology", 4);
        Score score2 = new Score("Ivanov Andrey", "Biology", 5);
        Score score3 = new Score("Ivanov Andrey", "Biology", 3);

        examinations.addScore(score1);
        examinations.addScore(score2);
        examinations.addScore(score3);

        Score actual = examinations.getScore(score3.name(), score3.subject());
        Assertions.assertEquals(score3, actual);
    }

    @Test
    void getScore() {
        Assertions.assertThrows(StudentAndSubjectNotFoundException.class, () -> examinations.getScore("Ivanov Andrey", "Biology"));
    }

    @Test
    void getAverageForSubject() {
        Score score1 = new Score("John Smith", "Algebra", 5);
        Score score2 = new Score("Coal Adam", "Algebra", 3);
        Score score3 = new Score("Ivanov Andrey", "Algebra", 5);
        Score score4 = new Score("Ivanov Andrey", "Biology", 3);
        Score score5 = new Score("John Smith", "Biology", 3);
        Score score6 = new Score("Coal Adam", "Biology", 4);

        examinations.addAllScore(List.of(score1, score2, score3, score4, score5, score6));

        Assertions.assertEquals(4.33, examinations.getAverageForSubject("Algebra"));
        Assertions.assertEquals(3.33, examinations.getAverageForSubject("Biology"));
    }

    @Test
    void multipleSubmissionsStudentNames() {
        Score score1 = new Score("John Smith", "Algebra", 5);
        Score score2 = new Score("Coal Adam", "Algebra", 3);
        Score score3 = new Score("Ivanov Andrey", "Algebra", 5);
        Score score4 = new Score("Ivanov Andrey", "Biology", 3);
        Score score5 = new Score("John Smith", "Biology", 3);

        examinations.addAllScore(List.of(score1, score2, score3, score4, score5));

        Set<String> multipleSubmissionsStudentNames = examinations.multipleSubmissionsStudentNames();

        Assertions.assertEquals(2, multipleSubmissionsStudentNames.size());
    }

    @Test
    void lastFiveStudentsWithExcellentMarkOnAnySubject() {
        Score score0 = new Score("Heck Sue", "Chemistry", 5);
        Score score1 = new Score("Smith John", "Algebra", 5);
        Score score2 = new Score("Coal Adam", "Algebra", 3);
        Score score3 = new Score("Ivanov Andrey", "Biology", 5);
        Score score4 = new Score("Ivanov Andrey", "Chemistry", 4);
        Score score5 = new Score("Smith John", "Biology", 3);
        Score score6 = new Score("Hughes Alise", "Economy", 5);
        Score score7 = new Score("Coal Adam", "Economy", 5);
        Score score8 = new Score("Ivanov Andrey", "Economy", 4);
        Score score9 = new Score("Wellburm Tom", "Biology", 4);

        examinations.addAllScore(List.of(score0, score1, score2, score3 ,score4, score5,
                score6, score7, score8, score9));

        Set<String> expectedStudents = new LinkedHashSet<>(List.of("Coal Adam", "Hughes Alise", "Ivanov Andrey", "Smith John", "Heck Sue"));
        Assertions.assertEquals(expectedStudents, examinations.lastFiveStudentsWithExcellentMarkOnAnySubject());
    }

    @Test
    void getAllScores() {
        Score score0 = new Score("Heck Sue", "Chemistry", 5);
        Score score1 = new Score("Smith John", "Algebra", 5);
        Score score2 = new Score("Coal Adam", "Algebra", 3);

        examinations.addAllScore(List.of(score0, score1, score2));

        Collection<Score> listOfScore = examinations.getAllScores();

        Assertions.assertEquals(3, listOfScore.size());
    }
}