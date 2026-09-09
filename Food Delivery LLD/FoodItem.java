public class FoodItem {

    private int foodId;

    private String foodName;

    private double price;

    private String category;

    private boolean available;


    public FoodItem(int foodId,
                    String foodName,
                    double price,
                    String category) {

        this.foodId = foodId;

        this.foodName = foodName;

        this.price = price;

        this.category = category;

        this.available = true;
    }


    public int getFoodId() {

        return foodId;
    }


    public String getFoodName() {

        return foodName;
    }


    public double getPrice() {

        return price;
    }


    public String getCategory() {

        return category;
    }


    public boolean isAvailable() {

        return available;
    }


    public void setAvailable(boolean available) {

        this.available = available;
    }
}