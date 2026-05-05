package BobsCircus;

public class Ticket {
    private double basePrice;
    private String dayOfWeek;
    private int age;

    public Ticket(String dayOfWeek, double basePrice, int age) {
        this.basePrice = basePrice;
        this.age = age;
        this.dayOfWeek = dayOfWeek.toLowerCase();
    }

    // Calculate ticket price based on day of week and age
    public double calculatePrice() {
        double finalPrice = basePrice;

        // Apply discounts for weekdays (10% discount for non-weekends)
        if (!dayOfWeek.equals("saturday") && !dayOfWeek.equals("sunday")) {
            finalPrice *= 0.90; 
        }

        // Apply age-based discounts
        if (age <= 12) {
            finalPrice *= 0.50; // Child gets 50% off
        } else if (age >= 65) {
            finalPrice *= 0.80; // Senior gets 20% off
        }
        
        return finalPrice;
    }

    // Display the ticket details
    public void displayTicketDetails() {
        System.out.printf("Ticket Details: [Age: %d, Day: %s, Price: $%.2f]%n",
                          age, dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), calculatePrice());
    }

    @Override
    public String toString() {
        return String.format("Ticket [Day: %s, Age: %d, Price: $%.2f]",
                             dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), 
                             age, calculatePrice());
    }
}