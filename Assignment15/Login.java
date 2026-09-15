import java.util.Scanner;

public class Login
{
    static void login(String password)
    {
        try
        {
            String correctPassword = "12345";

            if (!password.equals(correctPassword))
            {
                throw new Exception("Invalid password!");
            }

            System.out.println("Login successful.");
        }
        catch (Exception e)
        {
            System.out.println("Login failed.");
            System.out.println("Error: " + e.getMessage());
        }
        finally
        {
            System.out.println("Login process completed.");
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        login(password);

        sc.close();
    }
}