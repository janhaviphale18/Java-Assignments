import java.util.Scanner;

public class Shopping
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String[] products = {
            "Laptop",
            "Headphones",
            "Keyboard",
            "Mouse"
        };

        double[] prices = {
            60000,
            2500,
            1500,
            800
        };

        int[] stock = {
            5,
            10,
            15,
            20
        };

        double total = 0;

        System.out.println("=================================");
        System.out.println("        ONLINE SHOPPING");
        System.out.println("=================================");

        System.out.println("\nAvailable Products:");

        for (int i = 0; i < products.length; i++)
        {
            System.out.println(
                (i + 1) + ". " + products[i]
                + " - Rs. " + prices[i]
                + " | Stock: " + stock[i]
            );
        }

        try
        {
            System.out.print("\nEnter product number: ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > products.length)
            {
                throw new IllegalArgumentException(
                    "Invalid product number."
                );
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            // Quantity must be greater than zero
            if (quantity <= 0)
            {
                throw new IllegalArgumentException(
                    "Product quantity must be greater than zero."
                );
            }

            // Check available stock
            if (quantity > stock[choice - 1])
            {
                throw new IllegalArgumentException(
                    "Requested quantity is greater than available stock."
                );
            }

            double amount = prices[choice - 1] * quantity;

            total = total + amount;

            System.out.println("\n=================================");
            System.out.println("          ORDER SUMMARY");
            System.out.println("=================================");

            System.out.println("Product  : " + products[choice - 1]);
            System.out.println("Price    : Rs. " + prices[choice - 1]);
            System.out.println("Quantity : " + quantity);
            System.out.println("Total    : Rs. " + total);

            System.out.println("\nOrder placed successfully!");
        }

        catch (IllegalArgumentException e)
        {
            System.out.println("\nOrder Failed!");
            System.out.println("Error: " + e.getMessage());
        }

        catch (Exception e)
        {
            System.out.println("\nInvalid Input!");
            System.out.println("Error: Please enter valid numeric values.");
        }

        finally
        {
            System.out.println("\nThank you for shopping with us!");
        }

        sc.close();
    }
}