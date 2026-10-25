import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class TemperatureClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1100);

            TemperatureService converter =
                (TemperatureService) registry.lookup("TemperatureService");

            System.out.println("Connected to remote temperature converter.");

            Scanner keyboard = new Scanner(System.in);
            int choice;

            do {
                System.out.println();
                System.out.println("1. Celsius to Fahrenheit");
                System.out.println("2. Fahrenheit to Celsius");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                choice = keyboard.nextInt();

                if (choice == 1) {
                    System.out.print("Enter temperature in Celsius: ");
                    double c = keyboard.nextDouble();

                    double f = converter.celsiusToFahrenheit(c);
                    System.out.printf("%.2f C = %.2f F%n", c, f);

                } else if (choice == 2) {
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double f = keyboard.nextDouble();

                    double c = converter.fahrenheitToCelsius(f);
                    System.out.printf("%.2f F = %.2f C%n", f, c);

                } else if (choice != 3) {
                    System.out.println("Invalid choice. Try again.");
                }

            } while (choice != 3);

            System.out.println("Client closed.");

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}