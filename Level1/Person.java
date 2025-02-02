import java.util.Scanner;

class Person{

    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    Person(Person p){
        this.name = p.name;
        this.age = p.age;
    }

    void display(){
		System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        Person p1 = new Person(name, age);
        Person p2 = new Person(p1);
        p1.display();
        p2.display();
    }
	
}