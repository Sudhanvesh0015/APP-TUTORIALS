class Student {
    String name;
    int rollNo;
    String department;  public static void main(String[] args) {
        Student s = new Student();
         s.name = "Sunny";
        s.rollNo = 15;
        s.department = "CSE";

        System.out.println("Student Name: " + s.name);
        System.out.println("Roll Number: " + s.rollNo);
        System.out.println("Department: " + s.department);
    }
}