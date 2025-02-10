abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

interface Discountable {
    double applyDiscount(double amount);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount(double amount) {
        return amount * 0.9;
    }

    public String getDiscountDetails() {
        return "10% discount applied on Veg Items.";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private static final double ADDITIONAL_CHARGE = 1.2;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * ADDITIONAL_CHARGE;
    }

    public double applyDiscount(double amount) {
        return amount * 0.85;
    }

    public String getDiscountDetails() {
        return "15% discount applied on Non-Veg Items.";
    }
}

class OrderProcessor {
    public static void processOrder(FoodItem item) {
        double totalPrice = item.calculateTotalPrice();
        if (item instanceof Discountable) {
            Discountable discountItem = (Discountable) item;
            totalPrice = discountItem.applyDiscount(totalPrice);
            System.out.println(discountItem.getDiscountDetails());
        }
        System.out.println(item.getItemDetails() + ", Final Price: " + totalPrice);
    }
}

class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem veg = new VegItem("Paneer Butter Masala", 200, 2);
        FoodItem nonVeg = new NonVegItem("Chicken Biryani", 250, 2);

        OrderProcessor.processOrder(veg);
        OrderProcessor.processOrder(nonVeg);
    }
}
