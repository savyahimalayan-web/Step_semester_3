import java.util.*;

public class Main {
    interface Customer {
        double calculate(double amount);
    }

    static class Student implements Customer {
        public double calculate(double amount) {
            return amount * 0.90;
        }
    }

    static class Staff implements Customer {
        public double calculate(double amount) {
            return amount * 0.95;
        }
    }

    static class Guest implements Customer {
        public double calculate(double amount) {
            return amount + 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Customer> customers = new HashMap<>();
        customers.put("STUDENT", new Student());
        customers.put("STAFF", new Staff());
        customers.put("GUEST", new Guest());

        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            double finalAmount = customers.get(type).calculate(amount);
            total += finalAmount;

            System.out.printf("%s: %.2f%n", type, finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
