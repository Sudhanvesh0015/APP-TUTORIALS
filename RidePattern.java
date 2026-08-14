class Ride {
    int number;
    String name;
    Ride(int number, String name) {
        this.number = number;
        this.name = name;
    }
}
public class RidePattern {
    public static void main(String[] args) {
        Ride[] r = new Ride[5];
        r[0] = new Ride(1, "Roller Coaster");
        r[1] = new Ride(2, "Ferris Wheel");
        r[2] = new Ride(3, "Bumper Cars");
        r[3] = new Ride(4, "Water Ride");
        r[4] = new Ride(5, "Haunted House");
        for (int i = 0; i < 5; i++) {
            System.out.print(r[i].name + " : ");
            for (int j = 1; j <= r[i].number; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
