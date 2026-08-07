class Car {
    String model = "Not Specified";
    double price = 0;
    Car() { }
    Car(String model) {
        this.model = model;
    }
    Car(String model, double price) {
        this.model = model;
        this.price = price;
    }
    void display() {
        System.out.println("Model : " + model + " | Price : " + price);
    }
}
public class CarShowroom {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car("Swift");
        Car c3 = new Car("Creta", 1500000);

        c1.display();
        c2.display();
        c3.display();
    }
}
