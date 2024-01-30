package _2_object_and_class.lesson_3.workshop.geometry;

public class Rectangle {
    double a;
    double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void setA(double newA) {
        if (newA <= 0) {
            throw new IllegalArgumentException("A cannot be less than 0");
        }
        this.a = newA;
    }

    public void setB(double newB) {
        if (newB <= 0) {
            throw new IllegalArgumentException("B cannot be less than 0");
        }
        this.b = newB;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getArea() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Rectangle(" + a + ", " + b + ")";
    }
}
