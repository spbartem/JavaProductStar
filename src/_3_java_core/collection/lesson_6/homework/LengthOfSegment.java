package _3_java_core.collection.lesson_6.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LengthOfSegment {
    public static void main(String[] args) {
        try {
            Optional<Double> maxLength = new BufferedReader(new FileReader("segment.txt")).lines()
                    .map(LengthOfSegment::lengthOfSegment)
                    .max(Double::compare);
            System.out.println("Segment max length is " + String.format("%.2f", maxLength.orElseGet(() -> 0.0)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double lengthOfSegment(String line) {
        Pattern pattern = Pattern.compile("x:(\\d+),y:(\\d+)");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            int x1 = Integer.parseInt(matcher.group(1));
            int y1 = Integer.parseInt(matcher.group(2));
            if (matcher.find()) {
                int x2 = Integer.parseInt(matcher.group(1));
                int y2 = Integer.parseInt(matcher.group(2));
                return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            }
        }
        return 0;
    }
}
