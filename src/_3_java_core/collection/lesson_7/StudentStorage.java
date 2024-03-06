package _3_java_core.collection.lesson_7;

import java.util.HashMap;
import java.util.Map;

public class StudentStorage {
    private Map<Long, Student> studentStorageMap = new HashMap<>();
    private Long currentId = 0L;

    /**
     * Создание данных о студенте
     * @param student данные о студенте
     * @return сгенерированный уникальный идентификатор студента
     */
    public Long createStudent(Student student) {
        Long nextId = getNextId();
        studentStorageMap.put(nextId, student);
        return nextId;
    }

    /**
     * Обновление данных о студенте
     * @param id идентификатор студента
     * @param student данные студента
     * @return true если данные были обновлены, false если студент не был найден
     */
    public boolean updateStudent(Long id, Student student) {
        if (!studentStorageMap.containsKey(id)) {
            return false;
        } else {
            studentStorageMap.put(id, student);
            return true;
        }
    }

    /**
     * Удаление данных о студенте
     * @param id идентификатор студента
     * @return true если студент был удален, false если студент не был найден по идентификатору
     */
    public boolean deleteStudent(Long id) {
        Student removed = studentStorageMap.remove(id);
        return removed != null;
    }

    public Long getNextId() {
        currentId = currentId + 1;
        return currentId;
    }

    private void printAll() {
        System.out.println(studentStorageMap);
    }
}
