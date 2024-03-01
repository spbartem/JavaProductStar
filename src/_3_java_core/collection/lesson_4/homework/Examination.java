package _3_java_core.collection.lesson_4.homework;

import _3_java_core.collection.lesson_4.homework.exception.StudentAndSubjectNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface Examination {
    void addScore(Score score);

    Score getScore(String name, String subject) throws StudentAndSubjectNotFoundException;

    void addAllScore(List<Score> scores);

    double getAverageForSubject(String subject);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Collection<Score> getAllScores();
}
