public class RestaurantBilling
{
    static int totalOrders = 0;

    // Dine-In Order
    double calculateBill(double amount)
    {
        totalOrders++;
        return amount;
    }

    // Takeaway Order
    double calculateBill(double amount, double packingCharge)
    {
        totalOrders++;
        return amount + packingCharge;
    }

    // Delivery Order
    double calculateBill(double amount, double packingCharge, double deliveryCharge)
    {
        totalOrders++;
        return amount + packingCharge + deliveryCharge;
    }

    // Static method to display total orders
    static void showOrders()
    {
        System.out.println("Total Orders: " + totalOrders);
    }

    public static void main(String[] args)
    {
        RestaurantBilling obj = new RestaurantBilling();

        System.out.println("Dine-In Bill = " + obj.calculateBill(600));

        System.out.println("Takeaway Bill = " + obj.calculateBill(600, 30));

        System.out.println("Delivery Bill = " + obj.calculateBill(600, 30, 50));

        showOrders();
    }
}