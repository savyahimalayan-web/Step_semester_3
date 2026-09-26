import java.util.*;

public class Main {
    interface Vehicle {
        double calculate(int hours);
    }

    static class Bike implements Vehicle {
        public double calculate(int hours) {
            return 10.0 * hours;
        }
    }

    static class Car implements Vehicle {
        public double calculate(int hours) {
            if (hours <= 1) return 30.0;
            return 30.0 + 20.0 * (hours - 1);
        }
    }

    static class Truck implements Vehicle {
        public double calculate(int hours) {
            double charge = 50.0 * hours;
            return Math.max(charge, 100.0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("BIKE", new Bike());
        vehicles.put("CAR", new Car());
        vehicles.put("TRUCK", new Truck());

        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            double charge = vehicles.get(type).calculate(hours);
            total += charge;

            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
