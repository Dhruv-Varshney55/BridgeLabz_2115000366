import java.util.ArrayList;
import java.util.List;

class Product{
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
}

class Order{
    private int orderId;
    private Customer customer;
    private List<Product> products;

    public Order(int orderId, Customer customer){
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public double calculateTotal(){
        double total = 0;
        for(Product product : products){
            total += product.getPrice();
        }
        return total;
    }

    public void showOrderDetails(){
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products:");
        for(Product product : products){
            System.out.println(product.getName() + " (Rs." + product.getPrice() + ")");
        }
        System.out.println("Total Price: Rs." + calculateTotal());
    }
}

class Customer{
    private String name;
    private List<Order> orders;

    public Customer(String name){
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void placeOrder(Order order){
        orders.add(order);
    }

    public void showOrderHistory(){
        System.out.println("\nOrder History for " + name + ":");
        for(Order order : orders){
            order.showOrderDetails();
        }
    }
}

public class ECommerce{
    public static void main(String[] args){
        Customer dhruv = new Customer("Dhruv Varshney");
        Product laptop = new Product("Laptop", 52000.00);
        Product phone = new Product("Smartphone", 10000.00);
        Product headphones = new Product("Headphones", 2000.00);
        Order order1 = new Order(101, dhruv);
        order1.addProduct(laptop);
        order1.addProduct(phone);
        dhruv.placeOrder(order1);
        Order order2 = new Order(102, dhruv);
        order2.addProduct(headphones);
        dhruv.placeOrder(order2);
        dhruv.showOrderHistory();
    }
}