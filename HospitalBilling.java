class Patient {
    String name;
    double fee;
     Patient(String name, double fee) {
        this.name = name;
        this.fee = fee;
    }
}
public class HospitalBilling {
    static double finalAmount(double fee) {
        double discount = (fee >= 2000) ? fee * 0.10 : fee * 0.05;
        return fee - discount;
    }
    public static void main(String[] args) {
        Patient[] p = new Patient[5];
        p[0] = new Patient("pranav", 2500);
        p[1] = new Patient("sushanth", 1500);
        p[2] = new Patient("chinmay", 3200);
        p[3] = new Patient("hari", 1800);
        p[4] = new Patient("suhas", 2000);
        for (int i = 0; i < 5; i++) {
            double discount = p[i].fee - finalAmount(p[i].fee);
            System.out.println(p[i].name + " | Fee: " + p[i].fee
                    + " Discount: " + discount + " Final: " + finalAmount(p[i].fee));
        }
    }
}
