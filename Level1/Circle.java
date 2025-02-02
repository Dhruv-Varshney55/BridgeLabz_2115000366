import java.util.Scanner;

class Circle{

    double radius;

    Circle(){
        this(5.0);
    }

    Circle(double radius){
        this.radius = radius;
    }

    void display(){
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();
        Circle c1 = new Circle();
        Circle c2 = new Circle(radius);
        c1.display();
        c2.display();
    }
	
}