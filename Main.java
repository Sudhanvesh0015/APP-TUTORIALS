package OnlineExam;

class ExamTask implements Runnable {

    private String activity;
    private int delay;

    ExamTask(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    public void run() {

        for (int i = 1; i <= 3; i++) {

            System.out.println(
                Thread.currentThread().getName()
                + " : " + activity
            );

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        ExamTask time = new ExamTask(
            "Displaying Remaining Time", 1000
        );

        ExamTask save = new ExamTask(
            "Auto-saving Student Answers", 2000
        );

        ExamTask network = new ExamTask(
            "Checking Network Connection", 1500
        );

        Thread t1 = new Thread(time);
        Thread t2 = new Thread(save);
        Thread t3 = new Thread(network);

        t1.setName("Time Thread");
        t2.setName("AutoSave Thread");
        t3.setName("Network Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}
