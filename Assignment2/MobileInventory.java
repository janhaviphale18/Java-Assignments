public class MobileInventory
{
    String brand;
    String model;
    double price;

    // Default Constructor
    MobileInventory()
    {
        brand = "Samsung";
        model = "Galaxy A35";
        price = 30000;
    }

    // Parameterized Constructor
    MobileInventory(String b, String m, double p)
    {
        brand = b;
        model = m;
        price = p;
    }

    // Copy Constructor
    MobileInventory(MobileInventory obj)
    {
        brand = obj.brand;
        model = obj.model;
        price = obj.price;
    }

    void display()
    {
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
    }

    public static void main(String[] args)
    {
        MobileInventory m1 = new MobileInventory();

        MobileInventory m2 = new MobileInventory("Apple", "iPhone 16", 85000);

        MobileInventory m3 = new MobileInventory(m2);

        System.out.println("Default Constructor");
        m1.display();

        System.out.println();

        System.out.println("Parameterized Constructor");
        m2.display();

        System.out.println();

        System.out.println("Copy Constructor");
        m3.display();
    }
}