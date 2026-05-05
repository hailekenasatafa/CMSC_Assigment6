package BobsCircus;

public class Horse implements Animal {
    private String name;
    private int age;

    public Horse(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override public void makeSound() { System.out.println("Neigh!"); }
    @Override public void move() { System.out.println("Gallops"); }
    @Override public String getName() { return name; }
    @Override public int getAge() { return age; }
    @Override public String getSpecies() { return "Horse"; }
    @Override public String getColor() { return "Unknown"; }
    @Override public String getImagePath() { return ""; }
    @Override public String toString() { return "Horse: " + name; }
}