abstract class Vehicle{
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate){
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }

    public String getType(){
        return type;
    }

    public double getRentalRate(){
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable{
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable{
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber){
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public double calculateRentalCost(int days){
        return getRentalRate() * days;
    }

    public double calculateInsurance(){
        return getRentalRate() * 0.05;
    }

    public String getInsuranceDetails(){
        return "Car Insurance: 5% of rental rate";
    }
}

class Bike extends Vehicle{
    public Bike(String vehicleNumber, double rentalRate){
        super(vehicleNumber, "Bike", rentalRate);
    }

    public double calculateRentalCost(int days){
        return getRentalRate() * days;
    }
}

class Truck extends Vehicle implements Insurable{
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber){
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public double calculateRentalCost(int days){
        return getRentalRate() * days * 1.2;
    }

    public double calculateInsurance(){
        return getRentalRate() * 0.1;
    }

    public String getInsuranceDetails(){
        return "Truck Insurance: 10% of rental rate";
    }
}

public class VehicleRentalSystem{
    public static void calculateCosts(Vehicle vehicle, int days){
        double rentalCost = vehicle.calculateRentalCost(days);
        double insuranceCost = vehicle instanceof Insurable ? ((Insurable) vehicle).calculateInsurance() : 0;
        System.out.println(vehicle.getType() + " = Vehicle No: " + vehicle.getVehicleNumber() + ", Rental Cost: " + rentalCost + ", Insurance Cost: " + insuranceCost);
    }
	
    public static void main(String[] args){
        Vehicle car = new Car("UP86HJ43", 1000, "INS567");
        Vehicle bike = new Bike("UP81TY78", 500);
        Vehicle truck = new Truck("UP85NJ67", 2000, "INS890");
        calculateCosts(car, 5);
        calculateCosts(bike, 3);
        calculateCosts(truck, 7);
    }
}