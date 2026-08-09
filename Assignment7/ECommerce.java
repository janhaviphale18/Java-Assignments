interface Product
{
    void displayProduct();
}

class ProductDetails
{
    String name;
    double price;

    ProductDetails(String name, double price)
    {
        this.name = name;
        this.price = price;
    }
}

class Electronic extends ProductDetails implements Product
{
    String brand;

    Electronic(String name, double price, String brand)
    {
        super(name, price);
        this.brand = brand;
    }

    public void displayProduct()
    {
        System.out.println("Category : Electronic");
        System.out.println("Name     : " + name);
        System.out.println("Price    : " + price);
        System.out.println("Brand    : " + brand);
    }
}

class Clothing extends ProductDetails implements Product
{
    String size;

    Clothing(String name, double price, String size)
    {
        super(name, price);
        this.size = size;
    }

    public void displayProduct()
    {
        System.out.println("Category : Clothing");
        System.out.println("Name     : " + name);
        System.out.println("Price    : " + price);
        System.out.println("Size     : " + size);
    }
}

class Grocery extends ProductDetails implements Product
{
    String expiryDate;

    Grocery(String name, double price, String expiryDate)
    {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    public void displayProduct()
    {
        System.out.println("Category    : Grocery");
        System.out.println("Name        : " + name);
        System.out.println("Price       : " + price);
        System.out.println("Expiry Date : " + expiryDate);
    }
}

public class ECommerce
{
    public static void main(String[] args)
    {
        Electronic e = new Electronic("Laptop", 55000, "Dell");
        Clothing c = new Clothing("T-Shirt", 999, "L");
        Grocery g = new Grocery("Rice", 1200, "15-12-2026");

        System.out.println("--- Electronic Product ---");
        e.displayProduct();

        System.out.println("\n--- Clothing Product ---");
        c.displayProduct();

        System.out.println("\n--- Grocery Product ---");
        g.displayProduct();
    }
}