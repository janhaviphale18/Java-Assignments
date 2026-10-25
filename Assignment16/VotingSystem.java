import java.util.Scanner;

// Custom exception class
class InvalidAgeException extends java.lang.Exception {
    // Constructor
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Main class
public class VotingSystem {
    // Method to validate age
    static void validate(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is not valid to vote.");
        } else {
            System.out.println("Welcome to vote.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            validate(age);
        } catch (InvalidAgeException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        sc.close();
    }
}