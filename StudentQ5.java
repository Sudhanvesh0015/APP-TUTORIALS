class StudentQ5 {
    String name;
    int age;
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    public static void main(String[] args) {
        StudentQ5 s1 = new StudentQ5();
        StudentQ5 s2 = new StudentQ5();
        s1.name = "Sunny";
        s1.age = 19;
        s2.name = "Sai";
        s2.age = 19;
        s1.display();
        System.out.println();
        s2.display();
    }
}