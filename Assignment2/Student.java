public class Student
{
    String name;
    int rollNo;

    // Default Constructor
    Student()
    {
        name = "Janhavi";
        rollNo = 1;
    }

    // Parameterized Constructor
    Student(String n, int r)
    {
        name = n;
        rollNo = r;
    }

    void display()
    {
        System.out.println("Name : " + name);
        System.out.println("Roll No : " + rollNo);
    }

    public static void main(String[] args)
    {
        Student s1 = new Student();

        Student s2 = new Student("Rahul", 25);

        System.out.println("Student 1 Details");
        s1.display();

        System.out.println();

        System.out.println("Student 2 Details");
        s2.display();
    }
}