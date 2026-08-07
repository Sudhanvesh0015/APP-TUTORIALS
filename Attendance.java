public class Attendance {
    public static void main(String[] args) {
        int[] att = {1, 1, 0, 1, 1, 1, 0};
        int present = 0;
        for (int i = 0; i < 7; i++) {
            if (att[i] == 1) {
                present++;
            }
        }
        double percent = (present * 100.0) / 7;
        System.out.println("Present Days : " + present);
         if (percent >= 75) {
            System.out.println("Eligible for Exam");
        } else {
            System.out.println("Not Eligible");
        }
    }
}

