import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
class ServiceModel {
    public static final int GENERAL = 1000, OIL = 800, BRAKE = 1200, BATTERY = 500;
    private String regNo;
    private String vehicleType;
    private int totalCost;
    public void calculate(String regNo, String vehicleType,
                          boolean general, boolean oil, boolean brake, boolean battery) {
        this.regNo = regNo;
        this.vehicleType = vehicleType;
        totalCost = 0;
        if (general) totalCost += GENERAL;
        if (oil)     totalCost += OIL;
        if (brake)   totalCost += BRAKE;
        if (battery) totalCost += BATTERY;
    }
    public String getRegNo()       { return regNo; }
    public String getVehicleType() { return vehicleType; }
    public int getTotalCost()      { return totalCost; }
}
class ServiceView extends JFrame {
    private final JTextField regField = new JTextField(15);
    private final JRadioButton twoWheeler = new JRadioButton("Two Wheeler", true);
    private final JRadioButton car = new JRadioButton("Car");
    private final JCheckBox general = new JCheckBox("General Service - \u20B91,000");
    private final JCheckBox oil = new JCheckBox("Oil Change - \u20B9800");
    private final JCheckBox brake = new JCheckBox("Brake Service - \u20B91,200");
    private final JCheckBox battery = new JCheckBox("Battery Check - \u20B9500");
    private final JButton calcButton = new JButton("Calculate Cost");
    private final JLabel resultLabel = new JLabel(" ");
    public ServiceView() {
        super("Vehicle Service Cost Estimator");
        ButtonGroup group = new ButtonGroup();
        group.add(twoWheeler);
        group.add(car);
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        JPanel regRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        regRow.add(new JLabel("Registration No:"));
        regRow.add(regField);
        JPanel typeRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        typeRow.add(new JLabel("Vehicle Type:"));
        typeRow.add(twoWheeler);
        typeRow.add(car);
        panel.add(regRow);
        panel.add(typeRow);
        panel.add(new JLabel("Select Services:"));
        panel.add(general);
        panel.add(oil);
        panel.add(brake);
        panel.add(battery);
        panel.add(calcButton);
        panel.add(resultLabel);
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public String getRegNo()       { return regField.getText().trim(); }
    public String getVehicleType() { return twoWheeler.isSelected() ? "Two Wheeler" : "Car"; }
    public boolean isGeneral()     { return general.isSelected(); }
    public boolean isOil()         { return oil.isSelected(); }
    public boolean isBrake()       { return brake.isSelected(); }
    public boolean isBattery()     { return battery.isSelected(); }
    public void setResult(String html) { resultLabel.setText(html); }
    public void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void addCalculateListener(ActionListener l) { calcButton.addActionListener(l); }
}
class ServiceController {
    private final ServiceModel model;
    private final ServiceView view;

    public ServiceController(ServiceModel model, ServiceView view) {
        this.model = model;
        this.view = view;
        view.addCalculateListener(e -> calculate());
    }
    private void calculate() {
        if (view.getRegNo().isEmpty()) {
            view.showError("Please enter the vehicle registration number.");
            return;
        }
        if (!(view.isGeneral() || view.isOil() || view.isBrake() || view.isBattery())) {
            view.showError("Please select at least one service.");
            return;
        }
        model.calculate(view.getRegNo(), view.getVehicleType(),
                view.isGeneral(), view.isOil(), view.isBrake(), view.isBattery());
        view.setResult("<html>Vehicle: " + model.getRegNo() + " (" + model.getVehicleType()
                + ")<br>Total Service Cost: <b>\u20B9" + model.getTotalCost() + "</b></html>");
    }
}
public class ServiceCostEstimator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ServiceModel model = new ServiceModel();
            ServiceView view = new ServiceView();
            new ServiceController(model, view);
            view.setVisible(true);
        });
    }
}
