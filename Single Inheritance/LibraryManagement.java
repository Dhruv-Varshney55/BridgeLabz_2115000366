class Book{
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear){
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo(){
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book{
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio){
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}

public class LibraryManagement{
    public static void main(String[] args){
        Author bookWithAuthor = new Author("Head First Java", 2003, "Kathy Sierra", "Expert in Java programming with 15 years of experience");
        bookWithAuthor.displayInfo();
    }
}