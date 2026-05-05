package BobsCircus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CircusDriverApp {
    public static void main(String[] args) {
        Circus circus = new Circus();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to Bob's Circus Management System!");

        while (!exit) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Add Animal");
                System.out.println("2. Add Person");
                System.out.println("3. Add Building");
                System.out.println("4. Generate Ticket");
                System.out.println("5. Display All Animals");
                System.out.println("6. Display All Persons");
                System.out.println("7. Display All Buildings");
                System.out.println("8. Sort Animals by Age");
                System.out.println("9. Sort Animals by Name");
                System.out.println("10. Search Animal by Name");
                System.out.println("11. Exit\n");

                System.out.print("Choose an option: ");
              
                int choice = 0;
                boolean validInput = false;

                while (!validInput) {
                    try {
                        choice = validateInput(scanner);
                        validInput = true;
                    } catch (CustomInputMismatchException e) {
                        System.out.println(e.getMessage()); 
                        System.out.print("Choose an option: ");
                    }
                }
   
                switch (choice) {
                    case 1: handleAddAnimal(circus, scanner); break;
                    case 2: handleAddPerson(circus, scanner); break;
                    case 3: handleAddBuilding(circus, scanner); break;
                    case 4: handleGenerateTicket(scanner); break;
                    case 5: circus.displayAnimals(); break;
                    case 6: circus.displayPersons(); break;
                    case 7: circus.displayBuildings(); break;
                    case 8: circus.sortAnimalsByAge(); break;
                    case 9: circus.sortAnimalsByName(); break;                       
                    case 10:
                        System.out.print("Enter name: ");
                        String sName = scanner.nextLine();
                        Animal found = circus.searchAnimal(sName);
                        System.out.println(found != null ? found : "Not found.");
                        break;
                    case 11: exit = true; break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            } 
        }
        scanner.close();
    }

    private static int validateInput(Scanner scanner) throws CustomInputMismatchException {
        try {
            int input = scanner.nextInt();
            scanner.nextLine();
            return input;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new CustomInputMismatchException("Please enter a number.");
        }
    }

    private static void handleAddAnimal(Circus circus, Scanner scanner) {
        System.out.println("1. Bird 2. Lion");
        int type = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: "); String n = scanner.nextLine();
        System.out.print("Age: "); int a = scanner.nextInt(); scanner.nextLine();
        System.out.print("Species: "); String s = scanner.nextLine();
        System.out.print("Color: "); String c = scanner.nextLine();
        System.out.print("Path: "); String p = scanner.nextLine();
        if(type==1) circus.addAnimal(new Bird(n, a, s, c, p));
        else circus.addAnimal(new Lion(n, a, s, c, p));
    }

    private static void handleAddPerson(Circus circus, Scanner scanner) {
        System.out.println("1. Clerk 2. Acrobatic");
        int t = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: "); String n = scanner.nextLine();
        System.out.print("Age: "); int a = scanner.nextInt();
        System.out.print("Years: "); int y = scanner.nextInt(); scanner.nextLine();
        System.out.print("Job: "); String j = scanner.nextLine();
        System.out.print("Path: "); String p = scanner.nextLine();
        if(t==1) circus.addPerson(new Clerk(n, a, y, j, p));
        else circus.addPerson(new Acrobatic(n, a, y, j, p));
    }

    private static void handleAddBuilding(Circus circus, Scanner scanner) {
        System.out.print("Color: "); String c = scanner.nextLine();
        System.out.print("Len: "); double l = scanner.nextDouble();
        System.out.print("Wid: "); double w = scanner.nextDouble(); scanner.nextLine();
        circus.addBuilding(new Arena(c, l, w));
    }

    private static void handleGenerateTicket(Scanner scanner) {
        System.out.print("Base Price: ");
        double base = scanner.nextDouble(); scanner.nextLine();
        System.out.println("1. Mon ... 7. Sun");
        int day = scanner.nextInt(); scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt(); scanner.nextLine();
        Ticket t = new Ticket(DayOfWeek.values()[day-1].toString(), base, age);
        System.out.println(t);
    }
}