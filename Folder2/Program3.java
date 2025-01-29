import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Program3{
    public static void main(String[] args){
        LocalDate today = LocalDate.now();
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter f3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        System.out.println("Date in dd/MM/yyyy format: " + today.format(f1));
        System.out.println("Date in yyyy-MM-dd format: " + today.format(f2));
        System.out.println("Date in EEE, MMM dd, yyyy format: " + today.format(f3));
    }
}