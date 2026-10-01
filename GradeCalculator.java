import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
class StudentModel {
    private String name;
    private double m1, m2, m3;

    public void setDetails(String name, double m1, double m2, double m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    public String getName()    { return name; }
    public double getTotal()   { return m1 + m2 + m3; }
    public double getAverage() { return getTotal() / 3.0; }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }
}

class GradeView extends JFrame {
    private final JTextField nameField = new JTextField(15);
    private final JTextField m1Field = new JTextField(15);
    private final JTextField m2Field = new JTextField(15);
    private final JTextField m3Field = new JTextField(15);
    private final JButton calcButton = new JButton("Calculate Result");
    private final JLabel resultLabel = new JLabel(" ");

    public GradeView() {
        super("Student Grade Calculator");
        JPanel form = new JPanel(new GridLayout(5, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        form.add(new JLabel("Student Name:"));  form.add(nameField);
        form.add(new JLabel("Subject 1 Marks:")); form.add(m1Field);
        form.add(new JLabel("Subject 2 Marks:")); form.add(m2Field);
        form.add(new JLabel("Subject 3 Marks:")); form.add(m3Field);
        form.add(new JLabel());                 form.add(calcButton);

        resultLabel.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15));
        add(form, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public String getStudentName() { return nameField.getText().trim(); }
    public String getMark1() { return m1Field.getText().trim(); }
    public String getMark2() { return m2Field.getText().trim(); }
    public String getMark3() { return m3Field.getText().trim(); }

    public void setResult(String html) { resultLabel.setText(html); }
    public void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void addCalculateListener(ActionListener l) { calcButton.addActionListener(l); }
}
class GradeController {
    private final StudentModel model;
    private final GradeView view;

    public GradeController(StudentModel model, GradeView view) {
        this.model = model;
        this.view = view;
        view.addCalculateListener(e -> calculate());
    }

    private void calculate() {
        try {
            String name = view.getStudentName();
            if (name.isEmpty()) {
                view.showError("Please enter the student name.");
                return;
            }
            double a = Double.parseDouble(view.getMark1());
            double b = Double.parseDouble(view.getMark2());
            double c = Double.parseDouble(view.getMark3());
            if (!valid(a) || !valid(b) || !valid(c)) {
                view.showError("Marks must be between 0 and 100.");
                return;
            }
            model.setDetails(name, a, b, c);
            view.setResult(String.format(
                "<html>Student: %s<br>Total: %.2f<br>Average: %.2f<br>Grade: <b>%s</b></html>",
                model.getName(), model.getTotal(), model.getAverage(), model.getGrade()));
        } catch (NumberFormatException ex) {
            view.showError("Please enter valid numeric marks.");
        }
    }

    private boolean valid(double m) { return m >= 0 && m <= 100; }
}
public class GradeCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentModel model = new StudentModel();
            GradeView view = new GradeView();
            new GradeController(model, view);
            view.setVisible(true);
        });
    }
}