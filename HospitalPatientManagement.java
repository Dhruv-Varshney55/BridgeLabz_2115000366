import java.util.ArrayList;
import java.util.List;

abstract class Patient{
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age){
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId(){
        return patientId;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getPatientDetails(){
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public abstract double calculateBill();
}

interface MedicalRecord{
    void addRecord(String record);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord{
    private int admitDays;
    private double fee;
    private List<String> history = new ArrayList<>();

    public InPatient(String patientId, String name, int age, int admitDays, double fee){
        super(patientId, name, age);
        this.admitDays = admitDays;
        this.fee = fee;
    }

    public double calculateBill(){
        return admitDays * fee;
    }

    public void addRecord(String record){
        history.add(record);
    }

    public List<String> viewRecords(){
        return history;
    }
}

class OutPatient extends Patient implements MedicalRecord{
    private double consultFee;
    private List<String> history = new ArrayList<>();

    public OutPatient(String patientId, String name, int age, double consultFee){
        super(patientId, name, age);
        this.consultFee = consultFee;
    }

    public double calculateBill(){
        return consultFee;
    }

    public void addRecord(String record){
        history.add(record);
    }

    public List<String> viewRecords(){
        return history;
    }
}

public class HospitalPatientManagement{
    public static void processPatient(Patient patient){
        System.out.println(patient.getPatientDetails() + ", Bill: Rs." + patient.calculateBill());
    }

    public static void main(String[] args){
        InPatient inPatient = new InPatient("101", "Nobita", 15, 6, 1000);
        OutPatient outPatient = new OutPatient("102", "Shinchan", 12, 800);
        inPatient.addRecord("Fever and dehydration");
        outPatient.addRecord("Checkup for cold");
        processPatient(inPatient);
        processPatient(outPatient);
    }
}