package _3_java_core.collection.lesson_5.homework;

import java.util.*;

public class ResultBoard {
    TreeSet<Student> resultSet = new TreeSet<>();

    void addStudent(String name, Float score) {
        Student student = new Student();
        student.name = name;
        student.score = score;
        resultSet.add(student);
    }

    List<String> top3 () {
        int cnt = 0;
        List<String> top3 = new ArrayList<>();
        Iterator<Student> iterator = resultSet.descendingIterator();
        while (iterator.hasNext() && cnt < 3) {
            top3.add(iterator.next().toString());
            cnt++;
        }
        return top3;
    }

    public static void main(String[] args) {
        ResultBoard resultBoard = new ResultBoard();
        resultBoard.addStudent("Heck Sue", 4.82f);
        resultBoard.addStudent("Smith John", 4.50f);
        resultBoard.addStudent("Coal Adam", 3.98f);
        resultBoard.addStudent("Ivanov Andrey", 4.34f);
        resultBoard.addStudent("Wellburm Tom", 4.08f);

        System.out.println(resultBoard.top3());
    }
}

class Student implements Comparable<Student> {
    String name;
    Float score;

    @Override
    public int compareTo(Student o) {
        return Float.compare(score, o.score);
    }

    @Override
    public String toString() {
        return "[" + name + "] : " + score;
    }
}