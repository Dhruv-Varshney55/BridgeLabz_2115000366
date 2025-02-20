import java.util.*;
class Patient{
    String name;
    int severity;
	
    public Patient(String name, int severity){
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriageSystem{
    public static void main(String[] args){
        PriorityQueue<Patient> pq = new PriorityQueue<>(Comparator.comparingInt(p -> -p.severity));
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));
        while(!pq.isEmpty()){
            System.out.print(pq.remove().name + " ");
        }
    }
}