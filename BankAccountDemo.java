package WEEK5;
import java.util.Scanner;
class BankAccount {
    private String accNo, name;
    private double balance;
    BankAccount(String accNo, String name, double balance) {
        this.accNo = accNo; this.name = name; this.balance = balance;
    }
    void deposit(double amt) {
        if (amt <= 0) { System.out.println("Invalid amount"); return; }
        balance += amt;
        display();
    }
    void withdraw(double amt) {
        if (amt <= 0 || amt > balance) { System.out.println("Invalid withdrawal"); return; }
        balance -= amt;
        display();
    }
    void display() {
        System.out.println(accNo + " | " + name + " | Balance: " + balance);
    }
}
public class BankAccountDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("AccNo, Name, Balance: ");
        BankAccount acc = new BankAccount(sc.next(), sc.next(), sc.nextDouble());
        acc.display();
        System.out.print("Deposit amount: ");
        acc.deposit(sc.nextDouble());
        System.out.print("Withdraw amount: ");
        acc.withdraw(sc.nextDouble());
    }
}
