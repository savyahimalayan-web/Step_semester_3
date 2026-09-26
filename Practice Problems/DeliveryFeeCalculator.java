import java.util.*;

public class Main {
    interface Delivery {
        double calculate();
    }

    static class Standard implements Delivery {
        double weight, distance;
        Standard(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }
        public double calculate() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class Express implements Delivery {
        double weight, distance;
        Express(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }
        public double calculate() {
            return 15 + 1.00 * weight + 0.20 * distance;
        }
    }

    static class International implements Delivery {
        double weight, distance, customsFee;
        International(double weight, double distance, double customsFee) {
            this.weight = weight;
            this.distance = distance;
            this.customsFee = customsFee;
        }
        public double calculate() {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    interface DeliveryFactory {
        Delivery create(String[] params);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Map<String, DeliveryFactory> factories = new HashMap<>();
        factories.put("STANDARD", p -> new Standard(Double.parseDouble(p[0]), Double.parseDouble(p[1])));
        factories.put("EXPRESS", p -> new Express(Double.parseDouble(p[0]), Double.parseDouble(p[1])));
        factories.put("INTERNATIONAL", p -> new International(Double.parseDouble(p[0]), Double.parseDouble(p[1]), Double.parseDouble(p[2])));

        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String[] params = Arrays.copyOfRange(parts, 1, parts.length);

            Delivery delivery = factories.get(type).create(params);
            double fee = delivery.calculate();
            total += fee;

            System.out.printf("%s: %.2f%n", type, fee);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
