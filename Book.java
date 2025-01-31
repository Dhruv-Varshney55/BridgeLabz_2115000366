import java.util.Scanner;

class Book{

    String title;
    String author;
    int price;

    Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayDetails(){
		System.out.println();
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Book Price: ");
        int price = sc.nextInt();
        Book book = new Book(title, author, price);
        book.displayDetails();
    }
}