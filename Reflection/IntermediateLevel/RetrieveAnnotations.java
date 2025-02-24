import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Author{
    String name();
}

@Author(name = "Dhruv Varshney")
class Book{
    public void display(){
        System.out.println("Book class method executed");
    }
}

public class RetrieveAnnotations{
    public static void main(String[] args){
        try{
            Class<?> clazz = Book.class;
            if(clazz.isAnnotationPresent(Author.class)){
                Author author = clazz.getAnnotation(Author.class);
                System.out.println("Author: " + author.name());
            }
			else{
                System.out.println("No @Author annotation found");
            }
        }
		catch(Exception e){
            e.printStackTrace();
        }
    }
}