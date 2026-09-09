import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderId;

    private double totalAmount;

    private String status;

    private List<OrderItem> items;

    private Payment payment;


    public Order(int orderId) {

        this.orderId = orderId;

        this.status = "PLACED";

        this.items = new ArrayList<>();
    }


    public int getOrderId() {

        return orderId;
    }


    public double getTotalAmount() {

        return totalAmount;
    }


    public String getStatus() {

        return status;
    }


    public void setStatus(String status) {

        this.status = status;
    }


    public List<OrderItem> getItems() {

        return items;
    }


    public void addOrderItem(OrderItem item) {

        items.add(item);
    }


    public void calculateTotal() {

        totalAmount = 0;

        for (OrderItem item : items) {

            totalAmount =
                    totalAmount + item.getSubtotal();
        }
    }


    public void setPayment(Payment payment) {

        this.payment = payment;
    }


    public Payment getPayment() {

        return payment;
    }
}