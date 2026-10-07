import java.util.*;
public class CollegeFee {
    // Transport fee is stored in one place
    static final double TRANSPORT_FEE = 12000;
    // Abstract parent class
    static abstract class Student {
        String name;
        Student(String name) {
            this.name = name;
        }
        // Every student has a fee calculation
        abstract double calculateFee();
    }
    // Interface representing the ability to use college bus
    interface BusUser {
        boolean usesBus();
    }
    // Day scholar
    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }
        @Override
        double calculateFee() {
            return 40000 + TRANSPORT_FEE;
        }
        @Override
        public boolean usesBus() {
            return true;
        }
    }
    // Hosteller
    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }
        @Override
        double calculateFee() {
            return 40000 + 60000;
        }
    }
    // Scholarship student
    static class Scholar extends Student implements BusUser {
        Scholar(String name) {
            super(name);
        }
        @Override
        double calculateFee() {
            return 20000 + TRANSPORT_FEE;
        }
        @Override
        public boolean usesBus() {
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student;
            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            }
            else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            }
            else {
                student = new Scholar(name);
            }
            double fee = student.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
