import java.util.*;

public class Main {
    interface PaymentMethod {
        double calculate(double amount);
    }

    static class Card implements PaymentMethod {
        public double calculate(double amount) {
            return amount * 1.02;
        }
    }

    static class Wallet implements PaymentMethod {
        public double calculate(double amount) {
            return amount * 1.01;
        }
    }

    static class BankTransfer implements PaymentMethod {
        public double calculate(double amount) {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, PaymentMethod> methods = new HashMap<>();
        methods.put("CARD", new Card());
        methods.put("WALLET", new Wallet());
        methods.put("BANKTRANSFER", new BankTransfer());

        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod method = methods.get(type);
            double adjusted = method.calculate(amount);
            total += adjusted;

            System.out.printf("%s: %.2f%n", type, adjusted);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
