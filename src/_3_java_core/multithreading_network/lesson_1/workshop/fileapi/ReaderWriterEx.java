package _3_java_core.multithreading_network.lesson_1.workshop.fileapi;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Reader и Writer - это аналоги InputStream и OutputStream,
 * но в отличии от них они работают не с байтами, а с символами.
 *
 * Иногда их ещё называют символьными потоками, в противовес InputStream и OutputStream - байтовым потокам.
 */

public class ReaderWriterEx {
    public static void main(String[] args) throws IOException {
        //создаём список для хранения строк
        List<String> list = new ArrayList<>();

        //открываем файл
        File file = new File("C:\\Users\\user\\Documents\\java_classes\\ProductStar\\src\\_3_java_core\\" +
                "multithreading_network\\lesson_1\\workshop\\document.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        //пока файл не пуст - читаем из него
        while (reader.ready()) {
            list.add(reader.readLine());
        }

        //закрываем файл
        reader.close();

        List list2 = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        System.out.println(list2.size());
    }
}
