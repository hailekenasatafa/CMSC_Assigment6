package BobsCircus;

import java.util.ArrayList;
import java.util.List;

public class Circus {
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;
    private List<Ticket> tickets;

    public Circus() {
        animals = new ArrayList<>();
        persons = new ArrayList<>();
        buildings = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    // Add building
    public void addBuilding(Building b) {
        buildings.add(b);
    }

    // Display building
    public void displayBuildings() {
        for (Building b : buildings) {
            System.out.println(b.toString());
        }
    }

    // Add person
    public void addPerson(Person p) {
        persons.add(p);
    }

    // Display person
    public void displayPersons() {
        for (Person p : persons) {
            System.out.println(p.toString());
        }
    }

    // Add animal
    public void addAnimal(Animal a) {
        animals.add(a);
    }

    // Display animal using toString() method
    public void displayAnimals() {
        for (Animal a : animals) {
            System.out.println(a.toString());
        }
    }

    // Selection sort to sort animals by age
    public void sortAnimalsByAge() {
        for (int i = 0; i < animals.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(j).getAge() < animals.get(minIdx).getAge()) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the first element
            Animal temp = animals.get(minIdx);
            animals.set(minIdx, animals.get(i));
            animals.set(i, temp);
        }
    }
    
    // Selection sort to sort animals by name
    public void sortAnimalsByName() {
        for (int i = 0; i < animals.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < animals.size(); j++) {
                // Compare names alphabetically ignoring case differences
                if (animals.get(j).getName().compareToIgnoreCase(animals.get(minIdx).getName()) < 0) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the first element
            Animal temp = animals.get(minIdx);
            animals.set(minIdx, animals.get(i));
            animals.set(i, temp);
        }
    }
    
    // Search for an animal by name
    public Animal searchAnimal(String name) {
        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a; // Returns the animal if the name matches
            }
        }
        return null; // Returns null if no animal with that name exists
    }
    
    // Add ticket
    public void addTicket(Ticket t) {
        tickets.add(t);
    }

    // Generate ticket
    public Ticket generateTicket(String dayOfWeek, double basePrice, int age) {
        Ticket ticket = new Ticket(dayOfWeek, basePrice, age);  // Pass dayOfWeek, basePrice, age to Ticket constructor
        addTicket(ticket);
        return ticket;
    }
}