import java.util.*;

public class Main {
    interface Room {
        double calculate();
    }

    static class Single implements Room {
        int units;
        Single(int units) {
            this.units = units;
        }
        public double calculate() {
            return 8.0 * units;
        }
    }

    static class Shared implements Room {
        int units, occupants;
        Shared(int units, int occupants) {
            this.units = units;
            this.occupants = occupants;
        }
        public double calculate() {
            return (6.0 * units) / occupants;
        }
    }

    static class AC implements Room {
        int units;
        AC(int units) {
            this.units = units;
        }
        public double calculate() {
            return 10.0 * units + 200.0;
        }
    }

    interface RoomFactory {
        Room create(String[] params);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Map<String, RoomFactory> factories = new HashMap<>();
        factories.put("SINGLE", p -> new Single(Integer.parseInt(p[0])));
        factories.put("SHARED", p -> new Shared(Integer.parseInt(p[0]), Integer.parseInt(p[1])));
        factories.put("AC", p -> new AC(Integer.parseInt(p[0])));

        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String[] params = Arrays.copyOfRange(parts, 1, parts.length);

            double bill = factories.get(type).create(params).calculate();
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
