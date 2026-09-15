import java.util.Scanner;

public class ATM
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        double balance = 25000.00;

        try
        {
            System.out.println("=================================");
            System.out.println("          ATM MACHINE");
            System.out.println("=================================");

            System.out.println("Current Balance: Rs. " + balance);

            System.out.print("\nEnter withdrawal amount: ");
            double amount = sc.nextDouble();

            // Invalid withdrawal amount
            if (amount <= 0)
            {
                throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero."
                );
            }

            // Withdrawal amount greater than balance
            if (amount > balance)
            {
                throw new ArithmeticException(
                    "Insufficient balance."
                );
            }

            // ATM withdrawal limit
            if (amount > 20000)
            {
                throw new IllegalArgumentException(
                    "Maximum withdrawal limit is Rs. 20000."
                );
            }

            balance = balance - amount;

            System.out.println("\nWithdrawal successful.");
            System.out.println("Amount Withdrawn : Rs. " + amount);
            System.out.println("Remaining Balance: Rs. " + balance);
        }

        catch (IllegalArgumentException e)
        {
            System.out.println("\nInvalid Withdrawal!");
            System.out.println("Error: " + e.getMessage());
        }

        catch (ArithmeticException e)
        {
            System.out.println("\nTransaction Failed!");
            System.out.println("Error: " + e.getMessage());
        }

        catch (Exception e)
        {
            System.out.println("\nInvalid input!");
            System.out.println("Error: Please enter a valid numeric amount.");
        }

        sc.close();
    }
}