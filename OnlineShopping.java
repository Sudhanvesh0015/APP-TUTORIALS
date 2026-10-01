interface Payment {
    void pay(double amount);
}
class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount +
                " made using Credit Card.");
    }
}
class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount +
                " made using UPI.");
    }
}
class NetBankingPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount +
                " made using Net Banking.");
    }
}
public class OnlineShopping {
    public static void main(String[] args) {
        Payment p;
        p = new CreditCardPayment();
        p.pay(5000);
        p = new UPIPayment();
        p.pay(2500);
        p = new NetBankingPayment();
        p.pay(7500);
    }
}