public class JavaEnvironmentDemo {

    // Instance variables
    String studentName;
    int studentAge;

    // Constructor - initializes the object's variables
    JavaEnvironmentDemo(String name, int age) {
        this.studentName = name;
        this.studentAge = age;
    }

    // Instance method - displays student details
    void displayInfo() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Age : " + studentAge);
    }

    // Static method - performs addition of two numbers
    static int addNumbers(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        // Creating an object using the constructor
        JavaEnvironmentDemo obj = new JavaEnvironmentDemo("Rahul", 20);
        obj.displayInfo();

        // Calling a static method
        int sum = addNumbers(15, 25);
        System.out.println("Sum of two numbers: " + sum);

        // Local variable
        double pi = 3.14159;
        System.out.println("Value of Pi: " + pi);
    }
}
