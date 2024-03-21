package _3_java_core.multithreading_network.lesson_1.workshop.fileapi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Patterns {
    public static void main(String[] args) throws IOException {

        // передаём InputStream в конструктор InputStreamReader
        // В качестве InputStream мы используем уже ставшую привычной переменную System.in:
        // мы передаём объект "адаптируемого" класса "внутрь", т.е. в конструктор класса-адаптера.

        InputStreamReader inputStream = new InputStreamReader(System.in);

        /**
         * Есть класс OutputStream, который умеет записывать только одни байты; есть абстрактрый класс Writer,
         * который умеет работать с символами, и есть два несовместимых интерфейса.
         *
         * Эту проблему вновь решает паттер Адаптер.
         * При помощи класса OutputStreamWriter мы легко "адаптируем" два интерфейса классов
         * Writer и OutputStream друг к другу. И, получив байтовый поток OutputStream в конструктор,
         * с помощью OutputStreamWriter мы, тем не менее, можем записывать символы, а не байты.
         */

        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\user\\" +
                "Documents\\java_classes\\ProductStar\\src\\_3_java_core\\multithreading_network\\lesson_1\\workshop\\" +
                "NewFile.txt"));
        streamWriter.write(32144);
        streamWriter.close();

        /**
         * На схеме в презентации InputStream - абстрактный компонент.
         * Конкретные компоненты: FileInputStream, StringBufferInputStream, ByteArrayInputStream,
         * ObjectInputStream и др.
         *
         * Абстрактрый декоратор - FileInputStream, его потомки - конкретые декораторы:
         *
         * BufferedInputSteam - буферезует ввод для повышения производительности
         * и дополняет интерфейс новым методом readLine() для построчного чтения символьных данных.
         *
         * LineNumberInputStream - добавляет возможность подсчёта строк в процессе чтения данных.
         */
    }
}
