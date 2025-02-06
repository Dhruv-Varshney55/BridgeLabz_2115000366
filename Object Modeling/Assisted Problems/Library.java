import java.util.ArrayList;

class Book{
    String title;
    String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public void display(){
        System.out.println("Book: " + title + " by " + author);
    }
}

public class Library{
    String name;
    ArrayList<Book> books;

    public Library(String name){
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void displayBooks(){
        System.out.println("Library: " + name);
        for(Book book : books){
            book.display();
        }
    }

    public static void main(String[] args){
        Library library = new Library("Central Library");
        Book book1 = new Book("The God of Small Things", "Arundhati Roy");
        Book book2 = new Book("Midnight Children", "Salman Rushdie");
        Book book3 = new Book("Wings of Fire", "Dr. A.P.J. Abdul Kalam");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.displayBooks();
    }
}