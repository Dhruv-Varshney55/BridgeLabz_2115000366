import java.util.Scanner;

class Circle{

    double radius;

    Circle(double radius){
        this.radius = radius;
    }

    double calculateArea(){
        return 3.14 * radius * radius;
    }

    double calculateCircumference(){
        return 2 * 3.14 * radius;
    }

    void displayDetails(){
		System.out.println();
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Circle Radius: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        circle.displayDetails();
    }
}