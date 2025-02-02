import java.util.Scanner;

class CarRental{
    String customerName;
    String carModel;
    int rentalDays;
    int costPerDay = 250;

    CarRental(String customerName, String carModel, int rentalDays){
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    int calculateTotalCost(){
        return rentalDays * costPerDay;
    }

    void display(){
		System.out.println();
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: Rs." + calculateTotalCost());
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter car model: ");
        String model = sc.nextLine();
        System.out.print("Enter rental days: ");
        int days = sc.nextInt();
        CarRental cr = new CarRental(name, model, days);
        cr.display();
    }
}