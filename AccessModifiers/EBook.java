import java.util.Scanner;

class Book{

    public String ISBN;
    protected String title;
    private String author;

    Book(String ISBN, String title, String author){
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    void displayBookDetails(){
        System.out.println("\nBook Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}


class EBook extends Book{

    private String fileFormat;

    EBook(String ISBN, String title, String author, String fileFormat){
        super(ISBN, title, author);
        this.fileFormat = fileFormat;
    }

    void displayEBookDetails(){
        System.out.println("\nE-Book Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("File Format: " + fileFormat);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ISBN: ");
        String ISBN = sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter File Format (PDF, EPUB, etc.): ");
        String fileFormat = sc.nextLine();
        EBook ebook = new EBook(ISBN, title, author, fileFormat);
        ebook.displayBookDetails();
        ebook.displayEBookDetails();
    }
}