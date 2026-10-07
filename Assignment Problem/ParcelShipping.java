import java.util.*;
public class ParcelShipping {
    // Abstract parent class
    static abstract class Parcel {
        double weight;
        double declaredValue;
        Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }
        // Every parcel must calculate its shipping charge
        abstract double calculateCharge();
        // Standard parcel is not insurable
        double calculateInsurance() {
            return 0;
        }
    }
    // Interface for parcels that support insurance
    interface Insurable {
        double calculateInsurance();
    }
    // Standard parcel
    static class Standard extends Parcel {
        Standard(double weight, double declaredValue) {
            super(weight, declaredValue);
        }
        @Override
        double calculateCharge() {
            return 40 + (10 * weight);
        }
    }
    // Express parcel
    static class Express extends Parcel implements Insurable {
        Express(double weight, double declaredValue) {
            super(weight, declaredValue);
        }
        @Override
        double calculateCharge() {
            return 80 + (15 * weight);
        }
        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }
    // Fragile parcel
    static class Fragile extends Parcel implements Insurable {
        Fragile(double weight, double declaredValue) {
            super(weight, declaredValue);
        }
        @Override
        double calculateCharge() {
            // Standard charge + handling fee
            return 40 + (10 * weight) + 50;
        }
        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();
            Parcel parcel;
            if (type.equals("STANDARD")) {
                parcel = new Standard(weight, declaredValue);
            }
            else if (type.equals("EXPRESS")) {
                parcel = new Express(weight, declaredValue);
            }
            else {
                parcel = new Fragile(weight, declaredValue);
            }
            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
