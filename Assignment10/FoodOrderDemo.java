import java.util.Scanner;

abstract class FoodOrder
{
    String orderId;
    String customerName;
    double foodAmount;

    FoodOrder(String orderId, String customerName, double foodAmount)
    {
        this.orderId = orderId;
        this.customerName = customerName;
        this.foodAmount = foodAmount;
    }

    abstract void calculateBill();

    void displayOrderDetails()
    {
        System.out.println("Order ID      : " + orderId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Food Amount   : Rs. " + foodAmount);
    }
}

class DineInOrder extends FoodOrder
{
    int tableNumber;
    double serviceCharge;
    double tax;

    DineInOrder(String orderId, String customerName, double foodAmount,
                int tableNumber)
    {
        super(orderId, customerName, foodAmount);
        this.tableNumber = tableNumber;
        serviceCharge = foodAmount * 0.05;
        tax = foodAmount * 0.05;
    }

    void calculateBill()
    {
        double total = foodAmount + serviceCharge + tax;

        System.out.println("\nDINE-IN ORDER");
        System.out.println("==============");
        displayOrderDetails();
        System.out.println("Table Number  : " + tableNumber);
        System.out.println("Service Charge: Rs. " + serviceCharge);
        System.out.println("GST           : Rs. " + tax);
        System.out.println("Total Bill    : Rs. " + total);
    }
}

class TakeAwayOrder extends FoodOrder
{
    double packingCharge;
    double tax;

    TakeAwayOrder(String orderId, String customerName, double foodAmount)
    {
        super(orderId, customerName, foodAmount);
        packingCharge = 50;
        tax = foodAmount * 0.05;
    }

    void calculateBill()
    {
        double total = foodAmount + packingCharge + tax;

        System.out.println("\nTAKE-AWAY ORDER");
        System.out.println("================");
        displayOrderDetails();
        System.out.println("Packing Charge : Rs. " + packingCharge);
        System.out.println("GST            : Rs. " + tax);
        System.out.println("Total Bill     : Rs. " + total);
    }
}

public class FoodOrderDemo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("FOOD ORDER BILLING SYSTEM");
        System.out.println("=========================");

        System.out.print("Enter Order ID: ");
        String orderId = sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Food Amount: ");
        double amount = sc.nextDouble();

        System.out.println("\nSelect Order Type");
        System.out.println("1. Dine-In");
        System.out.println("2. Take-Away");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1)
        {
            System.out.print("Enter Table Number: ");
            int tableNumber = sc.nextInt();

            FoodOrder order = new DineInOrder(
                orderId,
                customerName,
                amount,
                tableNumber
            );

            order.calculateBill();
        }
        else if (choice == 2)
        {
            FoodOrder order = new TakeAwayOrder(
                orderId,
                customerName,
                amount
            );

            order.calculateBill();
        }
        else
        {
            System.out.println("Invalid Order Type.");
        }

        sc.close();
    }
}