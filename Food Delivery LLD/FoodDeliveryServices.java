import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryServices {

    private List<Restaurant> restaurants;

    private List<DeliveryPartner> deliveryPartners;

    private int orderId = 1001;

    private int paymentId = 1;


    public FoodDeliveryServices() {

        restaurants = new ArrayList<>();

        deliveryPartners = new ArrayList<>();
    }


    public void addRestaurant(Restaurant restaurant) {

        restaurants.add(restaurant);
    }


    public void addDeliveryPartner(
            DeliveryPartner partner) {

        deliveryPartners.add(partner);
    }


    public void addToCart(Customer customer,FoodItem foodItem,int quantity) {

        customer.getCart().addItem(
                foodItem,
                quantity
        );

        System.out.println(
                foodItem.getFoodName()
                + " added to cart"
        );
    }


    public Order placeOrder(Customer customer,
                            String paymentMethod) {

        if (customer.getCart().isEmpty()) {

            System.out.println("Cart is empty");

            return null;
        }


        Order order = new Order(orderId);

        orderId++;

        for (CartItem cartItem :
                customer.getCart().getItems()) {

            OrderItem orderItem =
                    new OrderItem(
                            cartItem.getFoodItem().getFoodName(),
                            cartItem.getFoodItem().getPrice(),
                            cartItem.getQuantity()
                    );

            order.addOrderItem(orderItem);
        }


        order.calculateTotal();


        Payment payment =
                new Payment(
                        paymentId,
                        order.getTotalAmount(),
                        paymentMethod
                );

        paymentId++;


        payment.makePayment();

        order.setPayment(payment);


        customer.getOrders().add(order);


        customer.getCart().clearCart();


        System.out.println(
                "Order #"
                + order.getOrderId()
                + " PLACED"
        );


        System.out.println(
                "Payment = "
                + payment.getPaymentMethod()
                + " - "
                + payment.getPaymentStatus()
        );


        return order;
    }


    public void acceptOrder(Order order) {

        if (order.getStatus().equals("PLACED")) {

            order.setStatus("ACCEPTED");

            System.out.println(
                    "Restaurant ACCEPTED the order"
            );
        }
    }


    public void rejectOrder(Order order) {

        if (order.getStatus().equals("PLACED")) {

            order.setStatus("REJECTED");

            System.out.println(
                    "Restaurant REJECTED the order"
            );
        }
    }


    public void assignDeliveryPartner(Order order) {

        for (DeliveryPartner partner :
                deliveryPartners) {

            if (partner.isAvailable()) {

                partner.setAvailable(false);

                System.out.println(
                        "Delivery Partner: "
                        + partner.getUsername()
                        + " assigned"
                );

                return;
            }
        }


        System.out.println(
                "No delivery partner available"
        );
    }


    public void updateOrderStatus(Order order, String status) {

        order.setStatus(status);

        System.out.println(
                "Status: " + status
        );


        if (status.equals("DELIVERED")
                || status.equals("CANCELLED")) {

            for (DeliveryPartner partner :
                    deliveryPartners) {

                if (!partner.isAvailable()) {

                    partner.setAvailable(true);

                    break;
                }
            }
        }
    }


    public void displayOrder(Order order) {

        System.out.println(
                "------------------------------"
        );


        System.out.println(
                "Order #" + order.getOrderId()
        );


        for (OrderItem item :
                order.getItems()) {

            System.out.println(
                    item.getQuantity()
                    + " x "
                    + item.getFoodName()
                    + " = Rs."
                    + item.getSubtotal()
            );
        }


        System.out.println(
                "------------------------------"
        );


        System.out.println(
                "Order Total = Rs."
                + order.getTotalAmount()
        );


        System.out.println(
                "Payment = "
                + order.getPayment().getPaymentMethod()
                + " - "
                + order.getPayment().getPaymentStatus()
        );


        System.out.println(
                "Status = "
                + order.getStatus()
        );
    }
}