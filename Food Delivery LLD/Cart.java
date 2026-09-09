import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int cartId;

    private List<CartItem> items;


    public Cart(int cartId) {

        this.cartId = cartId;

        this.items = new ArrayList<>();
    }


    public int getCartId() {

        return cartId;
    }


    public List<CartItem> getItems() {

        return items;
    }


    public void addItem(FoodItem foodItem,
                        int quantity) {

        CartItem cartItem =
                new CartItem(foodItem, quantity);

        items.add(cartItem);
    }


    public void removeItem(FoodItem foodItem) {

        for (CartItem item : items) {

            if (item.getFoodItem() == foodItem) {

                items.remove(item);

                break;
            }
        }
    }


    public double calculateTotal() {

        double total = 0;

        for (CartItem item : items) {

            total = total + item.getSubtotal();
        }

        return total;
    }


    public boolean isEmpty() {

        return items.isEmpty();
    }


    public void clearCart() {

        items.clear();
    }
}