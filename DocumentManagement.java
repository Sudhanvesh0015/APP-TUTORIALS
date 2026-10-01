interface Confidential {
}
class StudentDocument {
}
class EmployeeDocument implements Confidential {
}
class FinancialDocument implements Confidential {
}
public class DocumentManagement {
    public static void main(String[] args) {
        StudentDocument s = new StudentDocument();
        EmployeeDocument e = new EmployeeDocument();
        FinancialDocument f = new FinancialDocument();
        if (s instanceof Confidential) {
            System.out.println("Student Document is Confidential");
        } else {
            System.out.println("Student Document is NOT Confidential");
        }
        if (e instanceof Confidential) {
            System.out.println("Employee Document is Confidential");
        } else {
            System.out.println("Employee Document is NOT Confidential");
        }
        if (f instanceof Confidential) {
            System.out.println("Financial Document is Confidential");
        } else {
            System.out.println("Financial Document is NOT Confidential");
        }
    }
}