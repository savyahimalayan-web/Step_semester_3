import java.util.*;
public class HomeAppliance {
    static final double COST_PER_UNIT = 8;
    // Parent abstract class
    static abstract class Appliance {
        double hours;
        Appliance(double hours) {
            this.hours = hours;
        }
        // Each appliance supplies its power rating
        abstract double getPower();
        // Normal energy consumption
        double calculateUnits() {
            return (getPower() * hours) / 1000;
        }
        // Normal cost
        double calculateCost() {
            return calculateUnits() * COST_PER_UNIT;
        }
    }
    // Interface for appliances having saver mode
    interface SaverMode {
        double calculateSaverUnits();
    }
    static class Fridge extends Appliance {
        Fridge(double hours) {
            super(hours);
        }
        @Override
        double getPower() {
            return 150;
        }
    }
    static class AC extends Appliance implements SaverMode {
        AC(double hours) {
            super(hours);
        }
        @Override
        double getPower() {
            return 1500;
        }
        @Override
        public double calculateSaverUnits() {
            return calculateUnits() * 0.75;
        }
    }
    static class TV extends Appliance {
        TV(double hours) {
            super(hours);
        }
        @Override
        double getPower() {
            return 100;
        }
    }
    static class Washer extends Appliance implements SaverMode {
        Washer(double hours) {
            super(hours);
        }
        @Override
        double getPower() {
            return 500;
        }
        @Override
        public double calculateSaverUnits() {
            return calculateUnits() * 0.75;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            // Read the complete line because SAVER is optional
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length == 3 && parts[2].equals("SAVER");
            Appliance appliance;
            // Create appropriate appliance
            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            }
            else if (type.equals("AC")) {
                appliance = new AC(hours);
            }
            else if (type.equals("TV")) {
                appliance = new TV(hours);
            }
            else {
                appliance = new Washer(hours);
            }
            // Saver mode requested
            if (saverRequested) {
                // Check whether appliance supports saver mode
                if (!(appliance instanceof SaverMode)) {
                    System.out.println(type + ": saver mode not supported");
                    continue;
                }
                SaverMode saver = (SaverMode) appliance;
                double units = saver.calculateSaverUnits();
                double cost = units * COST_PER_UNIT;
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            }
            // Normal mode
            else {
                double units = appliance.calculateUnits();
                double cost = appliance.calculateCost();
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
