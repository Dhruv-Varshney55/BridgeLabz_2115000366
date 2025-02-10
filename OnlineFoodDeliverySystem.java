abstract class FoodItem{
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName(){
        return itemName;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getItemDetails(){
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

interface Discountable{
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable{
    public VegItem(String itemName, double price, int quantity){
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice(){
        return getPrice() * getQuantity();
    }

    public double applyDiscount(){
        return calculateTotalPrice() * 0.2;
    }

    public String getDiscountDetails(){
        return "Veg Item Discount: 10%";
    }
}

class NonVegItem extends FoodItem implements Discountable{
    private static final double ADDITIONAL_CHARGE = 50.0;

    public NonVegItem(String itemName, double price, int quantity){
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice(){
        return (getPrice() + ADDITIONAL_CHARGE) * getQuantity();
    }

    public double applyDiscount(){
        return calculateTotalPrice() * 0.1;
    }

    public String getDiscountDetails(){
        return "Non-Veg Item Discount: 5%";
    }
}

public class OnlineFoodDeliverySystem{
    public static void processOrder(FoodItem item){
        double totalPrice = item.calculateTotalPrice();
        double discount = item instanceof Discountable ? ((Discountable) item).applyDiscount() : 0;
        System.out.println(item.getItemDetails() + ", Total Price: " + totalPrice + ", Discount: " + discount);
    }

    public static void main(String[] args){
        FoodItem dosa = new VegItem("Dosa", 200, 2);
        FoodItem chickenTandoori = new NonVegItem("Chicken Tandoori", 500, 1);
        processOrder(dosa);
        processOrder(chickenTandoori);
    }
}