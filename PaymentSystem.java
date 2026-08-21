package WEEK5;
import java.util.Scanner;
interface PaymentMethod {
    void makePayment(double amount);
}
class UPIPayment implements PaymentMethod {
    String upiId;
    UPIPayment(String upiId) { this.upiId = upiId; }
    public void makePayment(double amt) { System.out.println("Paid " + amt + " via UPI (" + upiId + ")"); }
}
class CreditCardPayment implements PaymentMethod {
    String card;
    CreditCardPayment(String card) { this.card = card; }
    public void makePayment(double amt) { System.out.println("Paid " + amt + " via Card ending " + card.substring(card.length() - 4)); }
}
class NetBankingPayment implements PaymentMethod {
    String bank;
    NetBankingPayment(String bank) { this.bank = bank; }
    public void makePayment(double amt) { System.out.println("Paid " + amt + " via NetBanking (" + bank + ")"); }
}
public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Amount: ");
        double amt = sc.nextDouble();
        System.out.print("Choose 1-UPI 2-Card 3-NetBanking: ");
        int choice = sc.nextInt();
        PaymentMethod payment;
        switch (choice) {
            case 1: System.out.print("UPI ID: "); payment = new UPIPayment(sc.next()); break;
            case 2: System.out.print("Card No: "); payment = new CreditCardPayment(sc.next()); break;
            case 3: System.out.print("Bank: "); payment = new NetBankingPayment(sc.next()); break;
            default: System.out.println("Invalid choice"); return;
        }
        payment.makePayment(amt);
    }
}

