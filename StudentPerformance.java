class Student {
    int roll;
    String name;
    int[] marks = new int[3];
    double attendance;
    Student(int roll, String name, int m1, int m2, int m3, double attendance) {
        this.roll = roll;
        this.name = name;
        marks[0] = m1; marks[1] = m2; marks[2] = m3;
        this.attendance = attendance;
    }
}
public class StudentPerformance {
    public static void main(String[] args) {
        Student[] s = new Student[5];
        s[0] = new Student(1, "sudhanvesh:", 85, 90, 88, 92);
        s[1] = new Student(2, "sushanth  :", 40, 55, 48, 60);
        s[2] = new Student(3, "suahs     :", 70, 65, 72, 78);
        s[3] = new Student(4, "sai pranav:", 95, 92, 90, 85);
        s[4] = new Student(5, "Hari      :", 30, 45, 38, 89);
        double highest = -1;
        String topName = "";
        for (int i = 0; i < 5; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++)
                total += s[i].marks[j];
            double avg = total / 3.0;
            String result = (avg >= 50) ? "Pass" : "Fail";
            String scholarship = (avg >= 75 && s[i].attendance >= 80) ? "Eligible" : "Not Eligible";
            String grade = (avg >= 85) ? "Excellent" : "Good";
            System.out.println(s[i].name + "|Total:"+total+"Avg:"+avg+"|"+result+"|"+scholarship+"|"+grade);
            if (avg > highest) {
                highest = avg;
                topName = s[i].name;
            }
        }
        System.out.println("Highest average: " + topName + " (" + highest + ")");
    }
}