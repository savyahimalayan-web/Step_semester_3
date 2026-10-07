import java.util.*;
public class MovieTicket {
    // Abstract class because a plain Ticket should never be sold
    static abstract class Ticket {
        // Common convenience fee for every ticket
        static final double CONVENIENCE_FEE = 20;
        int count;
        Ticket(int count) {
            this.count = count;
        }
        // Each seat type must provide its own price
        abstract double getPrice();
        // Calculate total amount
        double getAmount() {
            return (getPrice() + CONVENIENCE_FEE) * count;
        }
    }
    // Regular seat
    static class Regular extends Ticket {
        Regular(int count) {
            super(count);
        }
        @Override
        double getPrice() {
            return 150;
        }
    }
    // Premium seat
    static class Premium extends Ticket {
        Premium(int count) {
            super(count);
        }
        @Override
        double getPrice() {
            return 250;
        }
    }
    // Recliner seat
    static class Recliner extends Ticket {
        Recliner(int count) {
            super(count);
        }
        @Override
        double getPrice() {
            return 400;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket ticket;
            // Create the appropriate ticket object
            if (seat.equals("REGULAR")) {
                ticket = new Regular(count);
            }
            else if (seat.equals("PREMIUM")) {
                ticket = new Premium(count);
            }
            else {
                ticket = new Recliner(count);
            }
            double amount = ticket.getAmount();
            total += amount;
            System.out.printf("%s: %.2f%n", seat, amount);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
