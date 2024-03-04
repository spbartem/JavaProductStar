package _3_java_core.collection.lesson_5.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ResultBoardTest {
    private ResultBoard resultBoard;

    @BeforeEach
    void setUp() { resultBoard = new ResultBoard(); }

    @Test
    void addStudent() {
        resultBoard.addStudent("Heck Sue", 4.82f);
        resultBoard.addStudent("Smith John", 4.50f);
        resultBoard.addStudent("Coal Adam", 3.98f);
        resultBoard.addStudent("Ivanov Andrey", 4.34f);
        resultBoard.addStudent("Wellburm Tom", 4.08f);

        Assertions.assertEquals(5, resultBoard.resultSet.size());
    }

    @Test
    void top3() {
        resultBoard.addStudent("Heck Sue", 4.82f);
        resultBoard.addStudent("Smith John", 4.50f);
        resultBoard.addStudent("Coal Adam", 3.98f);
        resultBoard.addStudent("Ivanov Andrey", 4.34f);
        resultBoard.addStudent("Wellburm Tom", 4.08f);

        List<String> expectedStudents = new ArrayList<>(List.of("[Heck Sue] : 4.82", "[Smith John] : 4.5", "[Ivanov Andrey] : 4.34"));

        Assertions.assertEquals(expectedStudents, resultBoard.top3());
    }
}