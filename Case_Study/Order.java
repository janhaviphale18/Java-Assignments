interface DeliveryStatus {
    void updateStatus(String status);
}

class Order {

    // Order data
    private int orderId;
    private String customerName;
    private double amount;

    // Constructor
    Order(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
    }

    // Inner class
    class OrderDetails {

        void display() {
            System.out.println("\n----- ORDER DETAILS -----");
            System.out.println("Order ID      : " + orderId);
            System.out.println("Customer Name : " + customerName);
            System.out.println("Amount        : Rs. " + amount);
        }
    }

    public static void main(String[] args) {

        // Creating Order object
        Order order = new Order(101, "Janhavi", 599.50);

        // Creating inner class object
        Order.OrderDetails details = order.new OrderDetails();

        // Display order information
        details.display();

        // Anonymous class implementing DeliveryStatus
        DeliveryStatus delivery = new DeliveryStatus() {

            @Override
            public void updateStatus(String status) {

                switch (status) {

                    case "ORDER_PLACED":
                        System.out.println(
                            "Status: ORDER_PLACED"
                        );
                        System.out.println(
                            "Message: Your order has been placed successfully."
                        );
                        break;

                    case "PREPARING":
                        System.out.println(
                            "Status: PREPARING"
                        );
                        System.out.println(
                            "Message: Your order is being prepared."
                        );
                        break;

                    case "OUT_FOR_DELIVERY":
                        System.out.println(
                            "Status: OUT_FOR_DELIVERY"
                        );
                        System.out.println(
                            "Message: Your order is out for delivery."
                        );
                        break;

                    case "DELIVERED":
                        System.out.println(
                            "Status: DELIVERED"
                        );
                        System.out.println(
                            "Message: Your order has been delivered successfully."
                        );
                        break;

                    default:
                        System.out.println(
                            "Status: INVALID"
                        );
                        System.out.println(
                            "Message: Invalid delivery status."
                        );
                }
            }
        };

        // Demonstrating different delivery statuses
        System.out.println("\n----- DELIVERY STATUS -----");

        delivery.updateStatus("ORDER_PLACED");
        delivery.updateStatus("PREPARING");
        delivery.updateStatus("OUT_FOR_DELIVERY");
        delivery.updateStatus("DELIVERED");
    }
}