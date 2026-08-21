package WEEK5;
import java.util.Scanner;
abstract class Employee {
    String name, id;
    double basic;
    Employee(String name, String id, double basic) {
        this.name = name; this.id = id; this.basic = basic;
    }
    abstract double calculateSalary();
        void display() {
        System.out.printf("%s | %s | %s | Salary: %.2f%n", id, name, getClass().getSimpleName(), calculateSalary());
    }
}
class Professor extends Employee {
    double researchAllowance;
    Professor(String n, String id, double b, double r) { super(n, id, b); researchAllowance = r; }
    double calculateSalary() { return basic + researchAllowance; }
}
class LabAssistant extends Employee {
    LabAssistant(String n, String id, double b) { super(n, id, b); }
    double calculateSalary() { return basic + 2000; }
}
class AdministrativeStaff extends Employee {
    AdministrativeStaff(String n, String id, double b) { super(n, id, b); }
    double calculateSalary() { return basic + basic * 0.10; }
}
public class EmployeeSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Professor - Name, ID, Basic, ResearchAllowance: ");
        Employee p = new Professor(sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble());
        System.out.print("LabAssistant - Name, ID, Basic: ");
        Employee l = new LabAssistant(sc.next(), sc.next(), sc.nextDouble());
        System.out.print("AdminStaff - Name, ID, Basic: ");
        Employee a = new AdministrativeStaff(sc.next(), sc.next(), sc.nextDouble());
        for (Employee e : new Employee[]{p, l, a})
             e.display();
    }
}

