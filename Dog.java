package BobsCircus;

public class Dog implements Animal {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override public void makeSound() { System.out.println("Woof!"); }
    @Override public void move() { System.out.println("Runs"); }
    @Override public String getName() { return name; }
    @Override public int getAge() { return age; }
    @Override public String getSpecies() { return "Dog"; }
    @Override public String getColor() { return "Unknown"; }
    @Override public String getImagePath() { return ""; }
    @Override public String toString() { return "Dog: " + name; }
}