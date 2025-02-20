import java.util.*;
public class ShoppingCart{
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cart.put(product, cart.getOrDefault(product, 0) + 1);
    }

    public Map<String, Integer> getCartOrder() {
        return cart;
    }

    public Map<Double, List<String>> getSortedByPrice() {
        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();
        for (var entry : productPrices.entrySet()) {
            sortedByPrice.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        return sortedByPrice;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 50000.0);
        cart.addProduct("Phone", 20000.0);
        cart.addProduct("Tablet", 15000.0);
        cart.addProduct("Mouse", 500.0);
        System.out.println("Cart Order: " + cart.getCartOrder());
        System.out.println("Sorted by Price: " + cart.getSortedByPrice());
    }
}