import java.util.Scanner;

class Book{

    String title;
    String author;
    int price;

    Book(){
        this.title = "Half Girlfriend";
        this.author = "Chetan Bhagat";
        this.price = 525;
    }

    Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display(){
		System.out.println();
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs." + price);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        Book b1 = new Book();
        Book b2 = new Book(title, author, price);
        b1.display();
        b2.display();
    }
	
}