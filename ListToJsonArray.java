import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Product> products = Arrays.asList(
            new Product("Laptop", 80000.50),
            new Product("Phone", 25000.00)
        );

        String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
        System.out.println(jsonArray);
    }
}