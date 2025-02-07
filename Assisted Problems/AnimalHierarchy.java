class Animal{
    protected String name;
    protected int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void makeSound(){
        System.out.println("Some animals sound");
    }
}

class Dog extends Animal{
    public Dog(String name, int age){
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println(name + " says: Woof! Woof! having " + age + " years old");
    }
}

class Cat extends Animal{
    public Cat(String name, int age){
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println(name + " says: Meow! having " + age + " years old");
    }
}

class Bird extends Animal{
    public Bird(String name, int age){
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println(name + " says: Chirp! Chirp! having " + age + " years old");
    }
}

public class AnimalHierarchy{
    public static void main(String[] args){
        Animal myDog = new Dog("Polar", 1);
        Animal myCat = new Cat("Chubby", 2);
        Animal myBird = new Bird("Kingu", 3);
        myDog.makeSound();
        myCat.makeSound();
        myBird.makeSound();
    }
}