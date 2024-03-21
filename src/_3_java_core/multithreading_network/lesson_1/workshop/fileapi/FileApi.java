package _3_java_core.multithreading_network.lesson_1.workshop.fileapi;

import java.io.File;
import java.io.IOException;

/**
 * Класс File, определённый в пакете Java.io, не работает напрямую с потоками.
 * Его задачей является управления информацией о файлах и каталогах.
 * Хотя на уровне операционный системы файлы и каталоги отличаются,
 * но в Java они описываются одним классом File.
 *
 * В зависимости от того, что должен представлять объект File - файл или каталог,
 * мы можем использовать один из конструкторов для создания объекта:
 *
 * File(String путь_к_каталогу)
 * File(String путь_к_каталогу, String имя_файла)
 * File(String каталог, String имя_файла)
 */

public class FileApi {
    //работа с каталогами
    public static void main(String[] args) {
        //определяем объект для каталога
        File dir = new File("C:\\Program Files");
        //если объект представляте каталог
        if (dir.isDirectory()) {
            //получаем все вложенные объекты в каталоге
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + " \t folder");
                } else {
                    System.out.println(item.getName() + " \t file");
                }
            }
        }
    }
}

class FileApi2 {
    public static void main(String[] args) {
        //определяем объект для каталога
        File myFile = new File("C:\\Users\\user\\Documents\\java_classes\\ProductStar\\src\\" +
                "_3_java_core\\multithreading_network\\lesson_1\\workshop\\document.txt");
        System.out.println("File name: " + myFile.getName());
        System.out.println("Parent folder " + myFile.getParent());

        if (myFile.exists()) {
            System.out.printf("File exists");
        } else {
            System.out.println("File not found");
        }

        System.out.println("File size: " + myFile.length());

        if (myFile.canRead()) {
            System.out.printf("File can be read");
        } else {
            System.out.printf("File can't be read");
        }

        if (myFile.canWrite())
            System.out.println("File can be written");
        else
            System.out.println("File can't be written");

        //создадим новый файл
        File newFile = new File("C:\\Users\\user\\Documents\\java_classes\\ProductStar\\src\\" +
                "_3_java_core\\multithreading_network\\lesson_1\\workshop\\NewFile.txt");
        try {
            boolean created = newFile.createNewFile();
            if (created)
                System.out.printf("File has been created");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(newFile.getAbsolutePath());
        System.out.println(newFile.canRead());
        System.out.println(newFile.canWrite());
        System.out.println(newFile.exists());
        System.out.println(newFile.getName());
        System.out.println(newFile.getParent());
        System.out.println(newFile.getPath());
        System.out.println(newFile.lastModified());
        System.out.println(newFile.isFile());
        System.out.println(newFile.isFile());
        System.out.println(newFile.isDirectory());
        System.out.println(newFile.isAbsolute());
    }
}
