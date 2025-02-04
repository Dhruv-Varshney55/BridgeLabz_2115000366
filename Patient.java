class Patient{
    static String hospitalName = "Pushpanjali Hospital";
    private String name;
    private int age;
    private String ailment;
    private final int patientID;
    private static int totalPatients = 0;

    public Patient(String name, int age, String ailment, int patientID){
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    static void getTotalPatients(){
		System.out.println();
        System.out.println("Total Patients: " + totalPatients);
    }

    void displayPatientDetails(){
        if(this instanceof Patient){
            System.out.println("\nName: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Hospital: " + hospitalName);
        }
    }

    public static void main(String[] args){
        Patient p1 = new Patient("Ronny", 28, "Fever", 100);
        Patient p2 = new Patient("Rahul", 29, "Cold", 101);
        p1.displayPatientDetails();
        p2.displayPatientDetails();
        getTotalPatients();
    }
}