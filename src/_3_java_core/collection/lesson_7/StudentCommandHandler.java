package _3_java_core.collection.lesson_7;

import java.util.Map;

public class StudentCommandHandler {

    private StudentStorage studentStorage = new StudentStorage();
    public void processCommand(Command command) {
        Action action = command.getAction();

        switch (action) {
            case CREATE -> {
                processCreateCommand(command);
                break;
            }
            case UPDATE -> {
                processUpdateCommand(command);
                break;
            }
            case DELETE -> {
                processDeleteCommand(command);
                break;
            }
            case STATS_BY_COURSE -> {
                processStatsByCourseCommand(command);
                break;
            }
            case STATS_BY_CITY -> {
                processStatsByCityCommand(command);
                break;
            }
            case SEARCH -> {
                processSearchCommand(command);
            }
            default -> {
                System.out.println("Действие " + action + " не поддерживается");
            }
        }

        System.out.println("Обработка команды. Действие: "
                + command.getAction().name()
                + ", данные: " + command.getData());
    }

    private void processSearchCommandWorkShop(Command command) {
        String surname = command.getData();
        studentStorage.searchWorkShop(surname);
    }

    private void processSearchCommand(Command command) {
        String surname = command.getData();
        studentStorage.search(surname);
    }

    private void processStatsByCourseCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCourse();
        studentStorage.printMap(data);
    }

    private void processStatsByCityCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCity();
        studentStorage.printMap(data);
    }

    private void processCreateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");

        Student student = new Student();
        student.setSurname(dataArray[0]);
        student.setName(dataArray[1]);
        student.setCourse(dataArray[2]);
        student.setCity(dataArray[3]);

        try {
            student.setAge(Integer.valueOf(dataArray[4]));
        } catch (Exception e) {
            System.out.println("Проблемы обработки введенных данных - возраст, д.б. целым числом, повторите ввод");
            return;
        }

        studentStorage.createStudent(student);
        studentStorage.printAll();
    }

    private void processUpdateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");
        if (!isNumeric(dataArray[0])) {
            System.out.println("Проблемы обработки введенных данных - идентификатор, д.б. целым числом, повторите ввод");
            return;
        }
        Long id = Long.valueOf(dataArray[0]);
        if (!isContainsKey(id)) {return;}

        Student student = new Student();
        student.setSurname(dataArray[1]);
        student.setName(dataArray[2]);
        student.setCourse(dataArray[3]);
        student.setCity(dataArray[4]);
        if (!isNumeric(dataArray[5])) {
            System.out.println("Проблемы обработки введенных данных - возраст, д.б. целым числом, повторите ввод");
            return;
        }
        student.setAge(Integer.valueOf(dataArray[5]));

        studentStorage.updateStudent(id, student);
        studentStorage.printAll();
    }

    private void processDeleteCommand(Command command) {

        String data = command.getData();
        if (!isNumeric(data)) {
            System.out.println("Проблемы обработки введенных данных - идентификатор, д.б. целым числом, повторите ввод");
            return;
        }
        Long id = Long.valueOf(data);
        if (!isContainsKey(id)) {return;}

        studentStorage.deleteStudent(id);
        studentStorage.printAll();
    }

    private boolean isNumeric(String string) {
        return string.matches("\\d+");
    }

    private boolean isContainsKey(Long id) {
        boolean res = studentStorage.getAll().containsKey(id);
        if (!res) {
            System.out.println("Студент с данным индентификатором отсутствует, повторите ввод");
            studentStorage.printAll();
        }
        return res;
    }
}
