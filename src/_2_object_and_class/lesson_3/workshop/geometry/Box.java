package _2_object_and_class.lesson_3.workshop.geometry;

public class Box extends Rectangle {
    private double c;

    public Box(double a, double b, double c) {
        super(a, b);
        this.c = c;
    }

    public double getVolume() {
        return a * b * c;
    }
}
