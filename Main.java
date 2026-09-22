import doctor.Doctor;
import patient.Patient;

public class Main {

    public static void main(String[] args) {

        Doctor d1 = new Doctor(101, "Dr. Arun", "Cardiologist", 1000);
        Doctor d2 = new Doctor(102, "Dr. Priya", "Dermatologist", 800);

        Patient p1 = new Patient(201, "Rahul", "Heart Disease", 45);
        Patient p2 = new Patient(202, "Anitha", "Skin Allergy", 30);
        Patient p3 = new Patient(203, "Karthik", "Heart Disease", 50);

        System.out.println("===== PATIENT 1 =====");
        p1.displayPatient();
        System.out.println("Treating Doctor:");
        d1.displayDoctor();

        System.out.println("\n===== PATIENT 2 =====");
        p2.displayPatient();
        System.out.println("Treating Doctor:");
        d2.displayDoctor();

        System.out.println("\n===== PATIENT 3 =====");
        p3.displayPatient();
        System.out.println("Treating Doctor:");
        d1.displayDoctor();

        double totalD1 = 2 * d1.getConsultationFee();
        double totalD2 = 1 * d2.getConsultationFee();

        System.out.println("\n===== TOTAL CONSULTATION FEE =====");
        System.out.println(d1.getName() + ": Rs." + totalD1);
        System.out.println(d2.getName() + ": Rs." + totalD2);
    }
}