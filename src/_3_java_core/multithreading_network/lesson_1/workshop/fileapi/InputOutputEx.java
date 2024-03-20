package _3_java_core.multithreading_network.lesson_1.workshop.fileapi;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InputOutputEx {
    public static void main(String[] args) throws Exception {
        //Создаём поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream("C:\\Users\\user\\Documents\\java_classes\\" +
                "ProductStar\\src\\_3_java_core\\multithreading_network\\lesson_1\\workshop\\data.txt");
        //создаём поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\user\\Documents\\java_classes\\" +
                "ProductStar\\src\\_3_java_core\\multithreading_network\\lesson_1\\workshop\\result.txt");

        byte[] buffer = new byte[1000];
        while (inputStream.available() > 0) //пока есть ещё непрочитанные байты
        {
            //прочитать очередной блок байт в переменную buffer и реальное количество в count
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count); //записать блок/часть блока во второй поток
        }

        inputStream.close(); //закрываем оба потока, они больше не нужны
        outputStream.close();
    }
}
