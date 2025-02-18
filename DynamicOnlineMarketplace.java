import java.util.ArrayList;
import java.util.List;

enum BookCategory{
    Fiction, Novel, Educational
}

enum ClothingCategory{
    MensWear, WomensWear, KidsWear
}

enum GadgetCategory{
    Mobile, Laptop, Tablet
}

class Product<T>{
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public T getCategory(){
        return category;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    @Override
    public String toString(){
        return name + " (" + category + ") - Rs." + price;
    }
}

class DiscountManager{
    public static <T extends Product<?>> void applyDiscount(T product, double percentage){
        double discount = product.getPrice() * (percentage / 100);
        double newPrice = product.getPrice() - discount;
        product.setPrice(newPrice);
    }
}

public class DynamicOnlineMarketplace{
    public static void main(String[] args){
        Product<BookCategory> book = new Product<>("Indikart", 250, BookCategory.Fiction);
        Product<ClothingCategory> shirt = new Product<>("Shirt", 600, ClothingCategory.MensWear);
        Product<GadgetCategory> phone = new Product<>("Samsung S25 Ultra", 130000, GadgetCategory.Mobile);

        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        System.out.println("Product Before Discount:");
        for(Product<?> p : catalog){
            System.out.println(p);
        }

        DiscountManager.applyDiscount(book, 10);
        DiscountManager.applyDiscount(shirt, 20);
        DiscountManager.applyDiscount(phone, 5);

        System.out.println("\nProduct After Discount:");
        for(Product<?> p : catalog){
            System.out.println(p);
        }
    }
}