abstract class Payment
{
    String payerName;
    double amount;

    Payment(String payerName, double amount)
    {
        this.payerName = payerName;
        this.amount = amount;
    }

    abstract void makePayment();

    void displayDetails()
    {
        System.out.println("Payer Name : " + payerName);
        System.out.println("Amount     : Rs. " + amount);
    }
}

class CreditCard extends Payment
{
    String cardNumber;

    CreditCard(String payerName, double amount, String cardNumber)
    {
        super(payerName, amount);
        this.cardNumber = cardNumber;
    }

    void makePayment()
    {
        System.out.println("Payment Method : Credit Card");
        System.out.println("Card Number    : " + cardNumber);
        System.out.println("Payment Status : Successful");
    }
}

class UPI extends Payment
{
    String upiId;

    UPI(String payerName, double amount, String upiId)
    {
        super(payerName, amount);
        this.upiId = upiId;
    }

    void makePayment()
    {
        System.out.println("Payment Method : UPI");
        System.out.println("UPI ID         : " + upiId);
        System.out.println("Payment Status : Successful");
    }
}

public class PaymentDemo
{
    public static void main(String[] args)
    {
        Payment p1 = new CreditCard(
            "Janhavi",
            2500,
            "XXXX-XXXX-1234"
        );

        System.out.println("Credit Card Payment");
        System.out.println("-------------------");
        p1.displayDetails();
        p1.makePayment();

        System.out.println();

        Payment p2 = new UPI(
            "Janhavi",
            1500,
            "janhavi@upi"
        );

        System.out.println("UPI Payment");
        System.out.println("-----------");
        p2.displayDetails();
        p2.makePayment();
    }
}