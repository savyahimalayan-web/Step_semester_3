import java.util.*;
public class CabFare {
    // Abstract parent class
    static abstract class Cab {
        double km;
        Cab(double km) {
            this.km = km;
        }
        // Each cab has its own rate
        abstract double getRate();
        // Common minimum-fare rule
        double calculateBaseFare() {
            double fare = km * getRate();
            // Fare cannot be below 100
            return Math.max(fare, 100);
        }
    }
    // Interface for cabs that support night service
    interface NightService {
        double applyNightFare(double fare);
    }
    // Mini cab
    static class Mini extends Cab {
        Mini(double km) {
            super(km);
        }
        @Override
        double getRate() {
            return 10;
        }
    }
    // Sedan cab
    static class Sedan extends Cab implements NightService {
        Sedan(double km) {
            super(km);
        }
        @Override
        double getRate() {
            return 14;
        }
        @Override
        public double applyNightFare(double fare) {
            return fare * 1.20;
        }
    }
    // SUV cab
    static class SUV extends Cab implements NightService {
        SUV(double km) {
            super(km);
        }
        @Override
        double getRate() {
            return 18;
        }
        @Override
        public double applyNightFare(double fare) {
            return fare * 1.20;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab;
            if (type.equals("MINI")) {
                cab = new Mini(km);
            }
            else if (type.equals("SEDAN")) {
                cab = new Sedan(km);
            }
            else {
                cab = new SUV(km);
            }
            // Mini does not support night service
            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }
            double fare = cab.calculateBaseFare();
            // Apply night fare only when supported
            if (time.equals("NIGHT")) {
                NightService nightCab = (NightService) cab;
                fare = nightCab.applyNightFare(fare);
            }
            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
