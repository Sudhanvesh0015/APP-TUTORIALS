class Employee {
    int id;
    String name;
    double salary;
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
public class EmployeeMangment {
    public static void main(String[] args) {
        Employee[] e = new Employee[5];
        e[0] = new Employee(201, "Ananya", 35000);
        e[1] = new Employee(202, "Vikram", 28000);
        e[2] = new Employee(203, "Priya", 45000);
        e[3] = new Employee(204, "Karthik", 30000);
        e[4] = new Employee(205, "Sneha", 22000);
        for (int i = 0; i < 5; i++) {
            double annual = e[i].salary * 12;
            boolean eligible = e[i].salary >= 30000;
            double bonus = eligible ? annual * 0.10 : 0;
            System.out.println("ID: " + e[i].id + " Name: " + e[i].name);
            System.out.println("Annual: " + annual + " Bonus: " + bonus + " Eligible: " + (eligible ? "Yes" : "No"));
        }
    }
}
