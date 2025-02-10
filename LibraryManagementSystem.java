abstract class LibraryItem{
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author){
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId(){
        return itemId;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getItemDetails(){
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public abstract int getLoanDuration();
}

interface Reservable{
    boolean reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable{
    private boolean isAvailable;

    public Book(String itemId, String title, String author, boolean isAvailable){
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    public int getLoanDuration(){
        return 20;
    }

    public boolean reserveItem(){
        if(isAvailable){
            isAvailable = false;
            return true;
        }
        return false;
    }

    public boolean checkAvailability(){
        return isAvailable;
    }
}

class Magazine extends LibraryItem{
    public Magazine(String itemId, String title, String author){
        super(itemId, title, author);
    }

    public int getLoanDuration(){
        return 14;
    }
}

class DVD extends LibraryItem implements Reservable{
    private boolean isAvailable;

    public DVD(String itemId, String title, String author, boolean isAvailable){
        super(itemId, title, author);
        this.isAvailable = isAvailable;
    }

    public int getLoanDuration(){
        return 7;
    }

    public boolean reserveItem(){
        if(isAvailable){
            isAvailable = false;
            return true;
        }
        return false;
    }

    public boolean checkAvailability(){
        return isAvailable;
    }
}

public class LibraryManagementSystem{
    public static void processLibraryItem(LibraryItem item){
        System.out.println(item.getItemDetails() + ", Loan Duration: " + item.getLoanDuration() + " days");
        if(item instanceof Reservable){
            Reservable reservable = (Reservable) item;
            System.out.println("Availability: " + reservable.checkAvailability());
        }
    }

    public static void main(String[] args){
        LibraryItem book = new Book("101", "Wings of Fire", "A.P.J. Abdul Kalam", true);
        LibraryItem magazine = new Magazine("201", "India Today", "Founded by Vidya Vilas Purie");
        LibraryItem dvd = new DVD("301", "Lagaan", "Directed by Ashutosh Gowariker", true);
        processLibraryItem(book);
        processLibraryItem(magazine);
        processLibraryItem(dvd);
    }
}