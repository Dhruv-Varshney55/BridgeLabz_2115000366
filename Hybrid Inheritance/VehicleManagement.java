class Vehicle{
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed){
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo(){
		System.out.println();
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

interface Refuelable{
    void refuel();
}

class ElectricVehicle extends Vehicle{
    private int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity){
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge(){
        System.out.println(model + " is charging, Battery capacity: " + batteryCapacity + " kWh");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable{
    private int fuelCapacity;

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity){
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel(){
        System.out.println(model + " is refueling, Fuel capacity: " + fuelCapacity + " liters");
    }
}

public class VehicleManagement{
    public static void main(String[] args){
        ElectricVehicle mahindra = new ElectricVehicle("Mahindra BE6E", 200, 70);
        mahindra.displayInfo();
        mahindra.charge();
        PetrolVehicle creta = new PetrolVehicle("Hyundai Creta SX", 180, 60);
        creta.displayInfo();
        creta.refuel();
    }
}