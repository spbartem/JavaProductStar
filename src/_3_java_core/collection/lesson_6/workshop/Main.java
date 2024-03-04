package _3_java_core.collection.lesson_6.workshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        try {
            Optional<Integer> max = new BufferedReader(new FileReader("data.txt")).lines()
                    .map(Integer::parseInt)
                    .max(Integer::compare);
            System.out.println(max.orElseGet(() -> 0));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
