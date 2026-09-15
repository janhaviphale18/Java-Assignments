import java.util.Scanner;

public class ATMPin
{
    static void verifyPin(int pin)
    {
        try
        {
            int correctPin = 1234;

            if (pin != correctPin)
            {
                throw new Exception("Invalid PIN!");
            }

            System.out.println("PIN verified successfully.");
            System.out.println("Access granted.");
        }
        catch (Exception e)
        {
            System.out.println("PIN verification failed.");
            System.out.println("Error: " + e.getMessage());
        }
        finally
        {
            System.out.println("PIN verification process completed.");
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ATM PIN: ");
        int pin = sc.nextInt();

        verifyPin(pin);

        sc.close();
    }
}