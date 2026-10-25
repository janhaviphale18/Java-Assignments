import java.util.Scanner;

// Custom unchecked exception class
class DivideByZeroException extends RuntimeException {
    // Constructor
    public DivideByZeroException(String message) {
        super(message);
    }
}

// Main class
public class CustomException2 {
    // Method to perform division
    static int divide(int a, int b) {
        // Check for division by zero
        if (b == 0) {
            throw new DivideByZeroException("Cannot divide by zero.");
        }

        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking numbers from user
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        try {
            int result = divide(a, b);
            System.out.println("Result: " + result);
        } catch (DivideByZeroException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        sc.close();
    }
}