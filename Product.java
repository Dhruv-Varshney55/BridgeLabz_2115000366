class Product{
    static int discount = 10;
    private String productName;
    private int price;
    private int quantity;
    private final int productID;

    public Product(String productName, int price, int quantity, int productID){
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    static void updateDiscount(int newDiscount){
        discount = newDiscount;
    }

    void displayProductDetails(){
        if(this instanceof Product){
            System.out.println("\nProduct: " + productName);
            System.out.println("Price: Rs." + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Product ID: " + productID);
            System.out.println("Discount: " + discount + "%");
        }
    }

    public static void main(String[] args){
        Product prod1 = new Product("Laptop", 65000, 2, 100);
        Product prod2 = new Product("Phone", 20000, 4, 101);
        prod1.displayProductDetails();
        prod2.displayProductDetails();
        updateDiscount(15);
        prod1.displayProductDetails();
        prod2.displayProductDetails();
    }
}