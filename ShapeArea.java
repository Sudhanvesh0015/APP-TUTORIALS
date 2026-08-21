package WEEK5;
import java.util.Scanner;
abstract class Shape {
    abstract double calculateArea();
    void display() { 
    System.out.printf("%s Area: %.2f%n", getClass().getSimpleName(), calculateArea()); }
}
class Circle extends Shape {
    double r;
    Circle(double r) { this.r = r; }
    double calculateArea() { return Math.PI * r * r; }
}
class Rectangle extends Shape {
    double l, w;
    Rectangle(double l, double w) { this.l = l; this.w = w; }
    double calculateArea() { return l * w; }
}
class Triangle extends Shape {
    double base, height;
    Triangle(double base, double height) { this.base = base; this.height = height; }
    double calculateArea() { return 0.5 * base * height; }
}
public class ShapeArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Circle radius: ");
        Shape circle = new Circle(sc.nextDouble());
        System.out.print("Rectangle length, width: ");
        Shape rect = new Rectangle(sc.nextDouble(), sc.nextDouble());
        System.out.print("Triangle base, height: ");
        Shape tri = new Triangle(sc.nextDouble(), sc.nextDouble());
        for (Shape s : new Shape[]{circle, rect, tri}) s.display();
    }
}
