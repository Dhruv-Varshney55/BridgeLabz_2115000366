class Person{
    protected String name;
    protected int id;

    public Person(String name, int id){
        this.name = name;
        this.id = id;
    }
	
    public void displayInfo(){
		System.out.println();
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

interface Worker{
    void performDuties();
}

class Chef extends Person implements Worker{
    private String specialty;

    public Chef(String name, int id, String specialty){
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties(){
        System.out.println(name + " is preparing " + specialty + " dishes");
    }
}

class Waiter extends Person implements Worker{
    private int tableCount;

    public Waiter(String name, int id, int tableCount){
        super(name, id);
        this.tableCount = tableCount;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving at " + tableCount + " tables");
    }
}

public class RestaurantManagement{
    public static void main(String[] args){
        Chef chef = new Chef("Ranveer Brar", 101, "Indian");
        chef.displayInfo();
        chef.performDuties();
        Waiter waiter = new Waiter("Ramu Kaka", 201, 10);
        waiter.displayInfo();
        waiter.performDuties();
    }
}