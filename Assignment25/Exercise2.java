class BankAccount {
    private int balance = 1000;

    synchronized void deposit(int amount) {
        balance += amount;

        System.out.println(
            Thread.currentThread().getName()
            + " deposited Rs. " + amount
            + " | Balance: Rs. " + balance
        );
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;

            System.out.println(
                Thread.currentThread().getName()
                + " withdrew Rs. " + amount
                + " | Balance: Rs. " + balance
            );
        } else {
            System.out.println(
                Thread.currentThread().getName()
                + " - Insufficient balance!"
            );
        }
    }

    synchronized int getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            account.deposit(500);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

class WithdrawalThread extends Thread {
    private BankAccount account;

    WithdrawalThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            account.withdraw(200);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        DepositThread t1 = new DepositThread(account);
        WithdrawalThread t2 = new WithdrawalThread(account);

        t1.setName("Deposit Thread");
        t2.setName("Withdrawal Thread");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(
            "Final Balance: Rs. " + account.getBalance()
        );
        System.out.println("All transactions completed.");
    }
}