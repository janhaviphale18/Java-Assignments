interface Printable
{
    void printDetails();
}

class Student implements Printable
{
    int rollNo;
    String name;
    String course;
    double marks;

    Student(int rollNo, String name, String course, double marks)
    {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public void printDetails()
    {
        System.out.println("STUDENT DETAILS");
        System.out.println("----------------");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Course      : " + course);
        System.out.println("Marks       : " + marks);
    }
}

class Employee implements Printable
{
    int employeeId;
    String name;
    String department;
    double salary;

    Employee(int employeeId, String name, String department, double salary)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void printDetails()
    {
        System.out.println("EMPLOYEE DETAILS");
        System.out.println("----------------");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : Rs. " + salary);
    }
}

public class PrintableDemo
{
    public static void main(String[] args)
    {
        Printable student = new Student(
            101,
            "Janhavi",
            "Computer Science",
            88.5
        );

        Printable employee = new Employee(
            501,
            "Rahul",
            "Software Development",
            75000
        );

        student.printDetails();

        System.out.println();

        employee.printDetails();
    }
}