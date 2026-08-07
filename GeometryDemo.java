class Geometry {
    double area(double side) {
        return side * side;
    }
    double area(double l, double b) {
        return l * b;
    }
    double area(double r, boolean isCircle) {
        return 3.14 * r * r;
    }
}
public class GeometryDemo {
    public static void main(String[] args) {
        Geometry g = new Geometry();
        System.out.println("Square Area : " + g.area(5));
        System.out.println("Rectangle Area : " + g.area(4, 6));
        System.out.println("Circle Area : " + g.area(7, true));
    }
}
