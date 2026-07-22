class MethOverloadandStatVarA
{
    // Static variable
    static int count;

    // Instance variables
    int a;
    int b;

    // Default Constructor
    MethOverloadandStatVarA()
    {
        System.out.println("Inside Default Constructor");

        a = 10;
        b = 20;
        count++;
    }

    // Parameterized Constructor
    MethOverloadandStatVarA(int p, int q)
    {
        System.out.println("Inside Parameterized Constructor");

        a = p;
        b = q;
        count++;
    }

    // Method with no parameters
    void show()
    {
        System.out.println("Value of a: " + a);
        System.out.println("Value of b: " + b);
    }

    // Method with two parameters
    void show(int p, int q)
    {
        System.out.println("Value of a: " + p);
        System.out.println("Value of b: " + q);
    }

    // Method with one parameter
    void show(int p)
    {
        System.out.println("Passed value: " + p);
    }

    // Static method
    static void countShow()
    {
        System.out.println("Total number of objects: " + count);
    }
}

public class MethodOverloading
{
    public static void main(String[] args)
    {
        // Object 1 - Default Constructor
        MethOverloadandStatVarA m1 =
            new MethOverloadandStatVarA();

        MethOverloadandStatVarA.countShow();

        m1.show();

        // Object 2 - Parameterized Constructor
        MethOverloadandStatVarA m2 =
            new MethOverloadandStatVarA(56, 89);

        MethOverloadandStatVarA.countShow();

        m2.show(m2.a, m2.b);

        // Object 3 - Parameterized Constructor
        MethOverloadandStatVarA m3 =
            new MethOverloadandStatVarA(100, 200);

        m3.show(m3.a);
        m3.show(m3.b);
    }
}