package _3_java_core.collection.lesson_7;

public class StudentCommandHandler {
    public void processCommand(Command command) {
        System.out.println("Обработка команды. Действие: "
                + command.getAction().name()
                + "данные: " + command.getData());
    }
}
