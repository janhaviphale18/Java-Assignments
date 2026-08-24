class BankAccount {
    final int accountNumber;
    String accountHolder;
    double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited : Rs. " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn : Rs. " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void displayAccount() {
        System.out.println("\nBank Account Details");
        System.out.println("--------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : Rs. " + balance);
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(
                102345,
                "Janhavi",
                25000
        );

        account.displayAccount();

        account.deposit(5000);
        account.withdraw(3000);

        account.displayAccount();

        // account.accountNumber = 123456;
        // Error: cannot assign a value to final variable
    }
}