class Employee {
    String name;
    int employeeId;
    double salary;

    Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Name : " + name);
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Salary        : " + salary);
    }
}

class Manager extends Employee {
    String department;
    int teamSize;

    Manager(String name, int employeeId, double salary,
            String department, int teamSize) {

        super(name, employeeId, salary);

        this.department = department;
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();

        System.out.println("Department    : " + department);
        System.out.println("Team Size     : " + teamSize);
    }

    void displayManagerInfo() {
        System.out.println("\nManager Information");

        // Accessing parent class variables using super
        System.out.println("Employee ID   : " + super.employeeId);
        System.out.println("Basic Salary  : " + super.salary);

        System.out.println("Department    : " + department);
        System.out.println("Team Size     : " + teamSize);
    }
}

public class EmployeeManager {
    public static void main(String[] args) {

        Manager manager = new Manager(
                "Janhavi",
                101,
                75000,
                "Software Development",
                8
        );

        System.out.println("Employee Details");

        manager.displayDetails();

        manager.displayManagerInfo();
    }
}