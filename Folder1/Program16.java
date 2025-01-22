import java.util.Scanner;
public class Program16{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int students = sc.nextInt();
        int handshakes = (students * (students - 1)) / 2;
        System.out.println("The maximum number of handshakes among " + students + " students is " + handshakes);
    }
}
