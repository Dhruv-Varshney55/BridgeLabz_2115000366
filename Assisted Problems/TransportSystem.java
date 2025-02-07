class Vehicle{
    protected int maxSpeed;
    protected String fuelType;

    public Vehicle(int maxSpeed, String fuelType){
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo(){
        System.out.println("Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle{
    private int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity){
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Vehicle Type: Car, Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle{
    private int loadCapacity;

    public Truck(int maxSpeed, String fuelType, int loadCapacity){
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Vehicle Type: Truck, Load Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle{
    private boolean hasSidecar;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar){
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Vehicle Type: Motorcycle, Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

public class TransportSystem{
    public static void main(String[] args){
        Vehicle[] vehicles ={
            new Car(180, "Petrol", 7),
            new Truck(100, "Diesel", 20),
            new Motorcycle(150, "Petrol", false)
        };
		
        for(Vehicle v : vehicles){
            v.displayInfo();
        }
    }
}