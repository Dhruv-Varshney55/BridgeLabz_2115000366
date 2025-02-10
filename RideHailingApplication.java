import java.util.Random;

abstract class Vehicle{
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm){
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId(){
        return vehicleId;
    }

    public String getDriverName(){
        return driverName;
    }

    public double getRatePerKm(){
        return ratePerKm;
    }

    public String getVehicleDetails(){
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: Rs." + ratePerKm;
    }

    public abstract double calculateFare(double distance);
}

interface GPS{
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS{
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm){
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    public double calculateFare(double distance){
        return distance * getRatePerKm();
    }

    public String getCurrentLocation(){
        return currentLocation;
    }

    public void updateLocation(String newLocation){
        this.currentLocation = newLocation;
    }
}

class Bike extends Vehicle implements GPS{
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm){
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    public double calculateFare(double distance){
        return distance * getRatePerKm() * 0.9;
    }

    public String getCurrentLocation(){
        return currentLocation;
    }

    public void updateLocation(String newLocation){
        this.currentLocation = newLocation;
    }
}

class Auto extends Vehicle implements GPS{
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm){
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    public double calculateFare(double distance){
        return distance * getRatePerKm() * 1.1;
    }

    public String getCurrentLocation(){
        return currentLocation;
    }

    public void updateLocation(String newLocation){
        this.currentLocation = newLocation;
    }
}

public class RideHailingApplication{
    public static void processRide(Vehicle vehicle, double distance){
        double fare = vehicle.calculateFare(distance);
        System.out.println(vehicle.getVehicleDetails() + ", Distance: " + distance + " Km, Fare: Rs." + fare);
    }

    public static void main(String[] args){
        Car car = new Car("101", "Dhruv Varshney", 10);
        Bike bike = new Bike("102", "Vikas Singh", 6);
        Auto auto = new Auto("103", "Ashwani Sahu", 8);
        car.updateLocation("Subway");
        bike.updateLocation("Center Point");
        auto.updateLocation("Railway Station");
        processRide(car, 350);
        processRide(bike, 50);
        processRide(auto, 20);
    }
}