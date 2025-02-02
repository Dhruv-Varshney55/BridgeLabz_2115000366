class Product{
	
    String productName;
    int price;
    static int totalProducts = 0;

    Product(String productName, int price){
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    void displayProductDetails(){
        System.out.println("Product Name: " + productName);
        System.out.println("Price: Rs." + price);
    }

    static void displayTotalProducts(){
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args){
        Product p1 = new Product("Laptop", 58000);
        Product p2 = new Product("Phone", 20000);
        Product p3 = new Product("Tablet", 15000);
        Product p4 = new Product("Ipad", 50000);
        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();
        p4.displayProductDetails();
        Product.displayTotalProducts();
    }
	
}