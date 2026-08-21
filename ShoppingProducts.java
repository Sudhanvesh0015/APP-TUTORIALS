package WEEK5;
import java.util.Scanner;
abstract class Product {
    String id, name;
    double price;
    Product(String id, String name, double price) {
        this.id = id; this.name = name; this.price = price;
    }
    abstract double calculateDiscount();
    double finalPrice() { return price - calculateDiscount(); }
    void display() {
        System.out.printf("%s | %s | %s | Price: %.2f Discount: %.2f Final: %.2f%n",
                id, name, getClass().getSimpleName(), price, calculateDiscount(), finalPrice());
    }
}
class Electronics extends Product {
    Electronics(String id, String n, double p) { super(id, n, p); }
    double calculateDiscount() { return price * 0.10; }
}
class Clothing extends Product {
    Clothing(String id, String n, double p) { super(id, n, p); }
    double calculateDiscount() { return price * 0.20; }
}
class Books extends Product {
    Books(String id, String n, double p) { super(id, n, p); }
    double calculateDiscount() { return price * 0.05; }
}
public class ShoppingProducts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Electronics - ID, Name, Price: ");
        Product e = new Electronics(sc.next(), sc.next(), sc.nextDouble());
        System.out.print("Clothing - ID, Name, Price: ");
        Product c = new Clothing(sc.next(), sc.next(), sc.nextDouble());
        System.out.print("Books - ID, Name, Price: ");
        Product b = new Books(sc.next(), sc.next(), sc.nextDouble());
        for (Product p : new Product[]{e, c, b}) p.display();
    }
}
