abstract class Product{
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price){
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId(){
        return productId;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public abstract double calculateDiscount();
}

interface Taxable{
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable{
    public Electronics(String productId, String name, double price){
        super(productId, name, price);
    }

    public double calculateDiscount(){
        return getPrice() * 0.10;
    }

    public double calculateTax(){
        return getPrice() * 0.18;
    }

    public String getTaxDetails(){
        return "Electronics Tax: 18%";
    }
}

class Clothing extends Product implements Taxable{
    public Clothing(String productId, String name, double price){
        super(productId, name, price);
    }

    public double calculateDiscount(){
        return getPrice() * 0.15;
    }

    public double calculateTax(){
        return getPrice() * 0.05;
    }

    public String getTaxDetails(){
        return "Clothing Tax: 5%";
    }
}

class Groceries extends Product{
    public Groceries(String productId, String name, double price){
        super(productId, name, price);
    }

    public double calculateDiscount(){
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform{
    public static void calculateFinalPrice(Product product){
        double discount = product.calculateDiscount();
        double tax = product instanceof Taxable ? ((Taxable) product).calculateTax() : 0;
        double finalPrice = product.getPrice() - discount + tax;
        System.out.println(product.getName() + " = Price: " + product.getPrice() + ", Discount: " + discount + ", Tax: " + tax + ", Final Price: " + finalPrice);
    }

    public static void main(String[] args){
        Product mobile = new Electronics("101", "Mobile", 25000);
        Product shirt = new Clothing("202", "Shirt", 800);
        Product pulse = new Groceries("G303", "Pulse", 100);
        calculateFinalPrice(mobile);
        calculateFinalPrice(shirt);
        calculateFinalPrice(pulse);
    }
}