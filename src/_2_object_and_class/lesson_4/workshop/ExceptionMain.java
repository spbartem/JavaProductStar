package _2_object_and_class.lesson_4.workshop;

import java.io.FileNotFoundException;
import java.net.SocketException;

public class ExceptionMain {
    public static void main(String[] args) throws AccessDeniedException {
        throw new AccessDeniedException("User A1 has no access to acc 123");
    }

    public static void doSomethingDangerous() throws FileNotFoundException, SocketException {
        readFile(null);
    };

    public static void readFile(String path) throws FileNotFoundException, SocketException {
        if (path == null) {
            throw new FileNotFoundException();
        }
        throw new SocketException();
    }
}
