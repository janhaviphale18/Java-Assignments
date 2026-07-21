class MethOverAndStatVar
{
    static int count;
    int a;
    int b;

    // Default Constructor
    MethOverAndStatVar()
    {
        System.out.println("Default Constructor");
        a = 10;
        b = 20;
        count++;
    }

    // Parameterized Constructor
    MethOverAndStatVar(int p, int q)
    {
        System.out.println("Parameterized Constructor");
        a = p;
        b = q;
        count++;
    }

    void show()
    {
        System.out.println("Value of a = " + a);
        System.out.println("Value of b = " + b);
    }

    void show(int p, int q)
    {
        System.out.println("Value of a = " + p);
        System.out.println("Value of b = " + q);
    }

    void show(int p)
    {
        System.out.println("Value of p = " +p);
    }

    static void countShow()
    {
        System.out.println("Total number of objects: " + count);
    }

    public static void main(String[] args)
    {
        MethOverAndStatVar m1 = new MethOverAndStatVar();
        m1.show();
        MethOverAndStatVar m2 = new MethOverAndStatVar(56, 70);
        m2.show(m2.a , m2.b);
        MethOverAndStatVar m3 = new MethOverAndStatVar();
        m3.show(m3.a);
        m3.show(m3.b);
    
        countShow();
    }
}