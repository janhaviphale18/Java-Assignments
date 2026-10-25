import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            CalculatorService calc =
                (CalculatorService) registry.lookup("CalculatorService");

            System.out.println("Connected to remote calculator service.");

            Scanner keyboard = new Scanner(System.in);

            System.out.print("Enter first number: ");
            double a = keyboard.nextDouble();

            System.out.print("Enter second number: ");
            double b = keyboard.nextDouble();

            System.out.println("-----------------------------");
            System.out.printf("Addition       : %.2f%n", calc.add(a, b));
            System.out.printf("Subtraction    : %.2f%n", calc.subtract(a, b));
            System.out.printf("Multiplication : %.2f%n", calc.multiply(a, b));

            if (b != 0) {
                System.out.printf("Division       : %.2f%n", calc.divide(a, b));
            } else {
                System.out.println("Division       : Cannot divide by zero");
            }

            System.out.println("-----------------------------");

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}