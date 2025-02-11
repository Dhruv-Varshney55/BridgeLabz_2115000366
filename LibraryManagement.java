import java.util.Scanner;

class Book{
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(int bookId, String title, String author, String genre, boolean isAvailable){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class Library{
    private Book head, tail;
    private int bookCount;

    public void addBookAtBeginning(int bookId, String title, String author, String genre, boolean isAvailable){
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if(head == null){
            head = tail = newBook;
        }
		else{
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    public void addBookAtEnd(int bookId, String title, String author, String genre, boolean isAvailable){
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if(head == null){
            head = tail = newBook;
        }
		else{
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    public void addBookAtPosition(int bookId, String title, String author, String genre, boolean isAvailable, int position){
        if(position <= 1){
            addBookAtBeginning(bookId, title, author, genre, isAvailable);
            return;
        }
        if(position > bookCount){
            addBookAtEnd(bookId, title, author, genre, isAvailable);
            return;
        }
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        Book temp = head;
        for(int i=1; i<position-1; i++){
            temp = temp.next;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
        bookCount++;
    }

    public void removeBook(int bookId){
        if(head == null){
            System.out.println("Library is empty");
            return;
        }
        Book temp = head;
        while(temp!=null && temp.bookId!=bookId){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Book not found");
            return;
        }
        if(temp == head){
            head = head.next;
            if(head != null){
				head.prev = null;
			}
        }
		else if(temp == tail){
            tail = tail.prev;
            tail.next = null;
        }
		else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        bookCount--;
    }

    public void searchByTitle(String title){
        Book temp = head;
        while(temp != null){
            if(temp.title.equalsIgnoreCase(title)){
                displayBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    public void searchByAuthor(String author){
        Book temp = head;
        while(temp != null){
            if(temp.author.equalsIgnoreCase(author)){
                displayBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    public void updateAvailability(int bookId, boolean isAvailable){
        Book temp = head;
        while(temp != null){
            if(temp.bookId == bookId){
                temp.isAvailable = isAvailable;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    public void displayBooksForward(){
        if(head == null){
            System.out.println("Library is empty");
            return;
        }
        Book temp = head;
        while(temp != null){
            displayBook(temp);
            temp = temp.next;
        }
    }

    public void displayBooksReverse(){
        if(tail == null){
            System.out.println("Library is empty");
            return;
        }
        Book temp = tail;
        while(temp != null){
            displayBook(temp);
            temp = temp.prev;
        }
    }

    public int countBooks(){
        return bookCount;
    }

    private void displayBook(Book book){
        System.out.println("ID: " + book.bookId + ", Title: " + book.title + ", Author: " + book.author + ", Genre: " + book.genre + ", Available: " + (book.isAvailable ? "Yes" : "No"));
    }
}

public class LibraryManagement{
    public static void main(String[] args){
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1. Add Book at Beginning\n2. Add Book at End\n3. Add Book at Position\n4. Remove Book\n5. Search by Title\n6. Search by Author\n7. Update Availability\n8. Display Books Forward\n9. Display Books Reverse\n10. Count Books\n11. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Book ID, Title, Author, Genre, Availability (true/false): ");
                    library.addBookAtBeginning(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextBoolean());
                    break;
                case 2:
                    System.out.print("Enter Book ID, Title, Author, Genre, Availability (true/false): ");
                    library.addBookAtEnd(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextBoolean());
                    break;
                case 3:
                    System.out.print("Enter Book ID, Title, Author, Genre, Availability (true/false), Position: ");
                    library.addBookAtPosition(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextBoolean(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Book ID to Remove: ");
                    library.removeBook(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Book Title to Search: ");
                    library.searchByTitle(sc.next());
                    break;
                case 6:
                    System.out.print("Enter Author Name to Search: ");
                    library.searchByAuthor(sc.next());
                    break;
                case 7:
                    System.out.print("Enter Book ID and New Availability (true/false): ");
                    library.updateAvailability(sc.nextInt(), sc.nextBoolean());
                    break;
                case 8:
                    library.displayBooksForward();
                    break;
                case 9:
                    library.displayBooksReverse();
                    break;
                case 10:
                    System.out.println("Total Books in Library: " + library.countBooks());
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}