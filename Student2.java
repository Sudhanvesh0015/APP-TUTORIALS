class Student2 {
    String name;
    int rollNo;
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }
    public static void main(String[] args) {
        Student2 s = new Student2();
        s.name = "Sudhanvesh";
        s.rollNo = 0015;
        s.display();
    }
}