abstract class Payment {

    private String transactionId;
    private double amount;

    Payment(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    // Getter methods
    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    // Abstract method
    abstract double processPayment();
}


// Credit Card Payment
class CreditCardPayment extends Payment {

    CreditCardPayment(String transactionId, double amount) {
        super(transactionId, amount);
    }

    @Override
    double processPayment() {
        // 2% convenience fee
        return getAmount() + (getAmount() * 0.02);
    }
}


// UPI Payment
class UPIPayment extends Payment {

    private String upiId;

    UPIPayment(String transactionId, double amount, String upiId) {
        super(transactionId, amount);
        this.upiId = upiId;
    }

    @Override
    double processPayment() {

        // UPI ID check
        if (upiId == null || upiId.isEmpty()) {
            System.out.println("Invalid UPI ID");
            return 0;
        }

        // No convenience fee
        return getAmount();
    }
}


// Payment Processor
class PaymentProcessor {

    void process(Payment payment) {
        System.out.println(
            "Transaction ID: " + payment.getTransactionId()
        );
        System.out.println(
            "Processed Amount: " + payment.processPayment()
        );
        System.out.println();
    }
}


// Main class
public class PaymentGateway {

    public static void main(String[] args) {

        // TC1: Credit Card Payment with 1000
        Payment creditCard = new CreditCardPayment(
            "CC101",
            1000
        );

        // TC2: UPI Payment with 1000
        Payment upi = new UPIPayment(
            "UPI101",
            1000,
            "janhavi@upi"
        );

        // PaymentProcessor can accept any Payment object
        PaymentProcessor processor = new PaymentProcessor();

        System.out.println("Credit Card Payment:");
        processor.process(creditCard);

        System.out.println("UPI Payment:");
        processor.process(upi);


        // TC3: Polymorphic array
        Payment[] payments = {
            creditCard,
            upi
        };

        double total = 0;

        System.out.println("Processing Payment Array:");

        for (Payment payment : payments) {

            double amount = payment.processPayment();

            System.out.println(
                payment.getTransactionId() +
                " = " + amount
            );

            total = total + amount;
        }

        System.out.println("Total = " + total);
    }
}