public class Payment {

    private int paymentId;

    private double amount;

    private String paymentMethod;

    private String paymentStatus;


    public Payment(int paymentId,
                   double amount,
                   String paymentMethod) {

        this.paymentId = paymentId;

        this.amount = amount;

        this.paymentMethod = paymentMethod;

        this.paymentStatus = "PENDING";
    }


    public void makePayment() {

        paymentStatus = "SUCCESS";
    }


    public int getPaymentId() {

        return paymentId;
    }


    public double getAmount() {

        return amount;
    }


    public String getPaymentMethod() {

        return paymentMethod;
    }


    public String getPaymentStatus() {

        return paymentStatus;
    }
}