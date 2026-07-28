class Vehicle
{
    String name = "Toyota";
    String model = "Fortuner";

    // Inner class
    class Details
    {
        void display()
        {
            System.out.println("Vehicle Name: " + name);
            System.out.println("Vehicle Model: " + model);
        }
    }

    public static void main(String[] args)
    {
        Vehicle v = new Vehicle();

        // Creating object of inner class
        Vehicle.Details d = v.new Details();
        d.display();

        // Anonymous class
        Runnable action = new Runnable()
        {
            public void run()
            {
                System.out.println("Vehicle is moving.");
            }
        };

        action.run();
    }
}