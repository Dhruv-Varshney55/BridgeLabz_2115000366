class Vehicle{

    String ownerName;
    String vehicleType;
    static int registrationFee = 1500;

    Vehicle(String ownerName, String vehicleType){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails(){
		System.out.println();
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: Rs." + registrationFee);
    }

    static void updateRegistrationFee(int newFee){
        registrationFee = newFee;
    }

    public static void main(String[] args){
        Vehicle v1 = new Vehicle("Dhruv", "Car");
        Vehicle v2 = new Vehicle("Ashwani", "Bike");
        Vehicle v3 = new Vehicle("Rishabh", "Tractor");
        Vehicle v4 = new Vehicle("Vikas", "Trolley");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
        v3.displayVehicleDetails();
        v4.displayVehicleDetails();
        updateRegistrationFee(2000);
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
        v3.displayVehicleDetails();
        v4.displayVehicleDetails();
    }
	
}