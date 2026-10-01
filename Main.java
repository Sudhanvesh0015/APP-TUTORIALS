class Account {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: Rs." + balance);
    }
}
class SavingsAccount extends Account {
    double interestRate;
    SavingsAccount(String accountNumber, String accountHolder,
                   double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }
    @Override
    void displayDetails() {
        System.out.println("Savings Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: Rs." + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
class CurrentAccount extends Account {
    double overdraftLimit;
    CurrentAccount(String accountNumber, String accountHolder,
                   double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    void displayDetails() {
        System.out.println("Current Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: Rs." + balance);
        System.out.println("Overdraft Limit: Rs." + overdraftLimit);
    }
}
interface Payment {
    void pay(double amount);
}
interface SecurePayment extends Payment {

    void verifyPayment();
}
interface OnlineTransaction {
}
class UPIPayment implements SecurePayment, OnlineTransaction {
    @Override
    public void pay(double amount) {
        System.out.println("UPI Payment of Rs." + amount + " successful.");
    }
    @Override
    public void verifyPayment() {
        System.out.println("UPI Payment verified successfully.");
    }
}
class CardPayment implements Payment, OnlineTransaction {

    @Override
    public void pay(double amount) {
        System.out.println("Card Payment of Rs." + amount + " successful.");
    }
}

public class Main {

    public static void main(String[] args) {

        // --------------------------------
        // Runtime Polymorphism
        // --------------------------------

        System.out.println("===== ACCOUNT DETAILS =====");
        Account account;
        account = new SavingsAccount(
                "SB1001",
                "Rahul",
                50000,
                6.5
        );
        account.displayDetails();
        System.out.println();
        account = new CurrentAccount(
                "CA2001",
                "ABC Enterprises",
                100000,
                50000
        );
        account.displayDetails();
        // --------------------------------
        // Payment Interface
        // --------------------------------
        System.out.println();
        System.out.println("===== PAYMENT DETAILS =====");
        Payment payment;
        payment = new UPIPayment();
        payment.pay(2500);
        payment = new CardPayment();
        payment.pay(5000);
        // --------------------------------
        // Secure Payment
        // --------------------------------
        System.out.println();
        System.out.println("===== SECURE PAYMENT =====");
        SecurePayment securePayment = new UPIPayment();
        securePayment.verifyPayment();
        securePayment.pay(3000);
        // --------------------------------
        // Tagging Interface
        // --------------------------------
        System.out.println();
        System.out.println("===== ONLINE TRANSACTION CHECK =====");
        Object obj1 = new UPIPayment();
        Object obj2 = new CardPayment();
        if (obj1 instanceof OnlineTransaction) {
            System.out.println("UPI is an Online Transaction.");
        }
        if (obj2 instanceof OnlineTransaction) {
            System.out.println("Card Payment is an Online Transaction.");
        }
    }
}