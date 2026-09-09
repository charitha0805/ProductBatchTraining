import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private int restaurantId;

    private String restaurantName;

    private String location;

    private boolean open;

    private List<FoodItem> foodItems;


    public Restaurant(int restaurantId,
                      String restaurantName,
                      String location) {

        this.restaurantId = restaurantId;

        this.restaurantName = restaurantName;

        this.location = location;

        this.open = true;

        this.foodItems = new ArrayList<>();
    }


    public int getRestaurantId() {

        return restaurantId;
    }


    public String getRestaurantName() {

        return restaurantName;
    }


    public String getLocation() {

        return location;
    }


    public boolean isOpen() {

        return open;
    }


    public void addFoodItem(FoodItem foodItem) {

        foodItems.add(foodItem);
    }


    public void removeFoodItem(FoodItem foodItem) {

        foodItems.remove(foodItem);
    }


    public List<FoodItem> getFoodItems() {

        return foodItems;
    }
}