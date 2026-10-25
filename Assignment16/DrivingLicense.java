import java.util.Scanner;

// Custom exception class
class InvalidDrivingAgeException extends java.lang.Exception {
    // Constructor
    public InvalidDrivingAgeException(String message) {
        super(message);
    }
}

// Main class
public class DrivingLicense {
    // Method to validate age
    static void validate(int age) throws InvalidDrivingAgeException {
        if (age < 18) {
            throw new InvalidDrivingAgeException(
                "Age is not valid for a driving license."
            );
        } else {
            System.out.println(
                "You are eligible for a driving license."
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            validate(age);
        } catch (InvalidDrivingAgeException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        sc.close();
    }
}