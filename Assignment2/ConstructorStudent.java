public class ConstructorStudent
{
    String name;
    int rollNo;

    // Default Constructor
    ConstructorStudent()
    {
        name = "Default";
        rollNo = 0;
    }

    // Parameterized Constructor
    ConstructorStudent(String n, int r)
    {
        name = n;
        rollNo = r;
    }

    // Copy Constructor
    ConstructorStudent(ConstructorStudent s)
    {
        name = s.name;
        rollNo = s.rollNo;
    }

    // Display student details
    void display()
    {
        System.out.println("Name : " + name);
        System.out.println("Roll No : " + rollNo);
    }

    public static void main(String[] args)
    {
        // Object using Default Constructor
        ConstructorStudent s1 = new ConstructorStudent();

        // Object using Parameterized Constructor
        ConstructorStudent s2 = new ConstructorStudent("Sweety", 101);

        // Object using Copy Constructor
        ConstructorStudent s3 = new ConstructorStudent(s2);

        System.out.println("Default Constructor:");
        s1.display();

        System.out.println("\nParameterized Constructor:");
        s2.display();

        System.out.println("\nCopy Constructor:");
        s3.display();
    }
}