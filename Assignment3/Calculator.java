public class Calculator
{
    static int count = 0;

    
    int add(int a, int b)
    {
        count++;
        return a + b;
    }

    
    double add(double a, double b)
    {
        count++;
        return a + b;
    }

    
    static void show()
    {
        System.out.println("Total Calculations: " + count);
    }

    public static void main(String[] args)
    {
        Calculator obj = new Calculator();

        System.out.println("Integer Addition = " + obj.add(10, 20));

        System.out.println("Decimal Addition = " + obj.add(10.5, 20.5));

        show();
    }
}