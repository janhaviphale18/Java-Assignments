class FoodDelivery
{
    String food = "Pizza";
    int quantity = 2;

    // Inner class
    class Order
    {
        void display()
        {
            System.out.println("Food Item: " + food);
            System.out.println("Quantity: " + quantity);
        }
    }

    public static void main(String[] args)
    {
        FoodDelivery f = new FoodDelivery();

        // Creating object of inner class
        FoodDelivery.Order o = f.new Order();
        o.display();

        // Anonymous class
        Runnable delivery = new Runnable()
        {
            public void run()
            {
                System.out.println("Delivery Status: Food Delivered");
            }
        };

        delivery.run();
    }
}