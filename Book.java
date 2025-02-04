class Book{
    static String libraryName = "Central Library";
    private String title;
    private String author;
    private final String isbn;
	
    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName(){
        System.out.println("Library Name: " + libraryName);
    }

    void displayBookDetails(){
        if(this instanceof Book){
            displayLibraryName();
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    public static void main(String[] args){
        Book book1 = new Book("Engineering Mathematics", "P. Bali", "9725385356537");
        Book book2 = new Book("Head First Java", "Kathy Sierra", "9274563478587");
        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}