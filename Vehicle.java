class Vehicle{
    static int registrationFee = 2000;
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(int newFee){
        registrationFee = newFee;
    }

    void displayVehicleDetails(){
        if(this instanceof Vehicle){
            System.out.println("\nOwner: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: Rs." + registrationFee);
        }
    }

    public static void main(String[] args){
        Vehicle car = new Vehicle("Dhruv", "Car", "UP86X434");
        Vehicle truck = new Vehicle("Vikas", "Truck", "UP86IHDG");
        car.displayVehicleDetails();
        truck.displayVehicleDetails();
        updateRegistrationFee(5000);
        car.displayVehicleDetails();
        truck.displayVehicleDetails();
    }
}