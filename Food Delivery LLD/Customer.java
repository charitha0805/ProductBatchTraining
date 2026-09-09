import java.util.ArrayList;
import java.util.List;

public class Customer extends user {

    private int customerId;

    private Cart cart;

    private List<Order> orders;


    public Customer(int customerId,
                    String username,
                    String password,
                    long phone,
                    String address) {

        super(username, password, phone, address);

        this.customerId = customerId;

        this.cart = new Cart(customerId);

        this.orders = new ArrayList<>();
    }


    public int getCustomerId() {

        return customerId;
    }


    public Cart getCart() {

        return cart;
    }


    public List<Order> getOrders() {

        return orders;
    }
}