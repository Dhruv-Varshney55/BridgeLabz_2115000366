import java.util.Scanner;

class Book2{
    String title;
    String author;
    int price;
    boolean available;

    Book2(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    void borrowBook(){
        if(available){
            available = false;
            System.out.println("Book borrowed successfully");
        }
		else{
            System.out.println("Book is already borrowed");
        }
    }

    void display(){
		System.out.println();
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs." + price);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        Book2 b = new Book2(title, author, price);
        b.display();
        b.borrowBook();
        b.display();
		b.borrowBook();
    }
}