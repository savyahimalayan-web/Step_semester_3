public class PiggyBankDemo {

    static class PiggyBank {

        // Private savings amount
        private double savings;

        // Final ID cannot be changed
        private final String piggyBankId;

        // Constructor
        public PiggyBank(String piggyBankId) {
            this.piggyBankId = piggyBankId;
            this.savings = 0;
        }

        // Deposit money
        public void deposit(double amount) {

            if (amount > 0) {
                savings += amount;
            }
        }

        // Withdraw money
        public void withdraw(double amount) {

            if (amount <= savings) {
                savings -= amount;
            } else {
                System.out.println("Withdrawal rejected");
            }
        }

        // Getter for savings
        public double getSavings() {
            return savings;
        }

        // Getter for ID
        public String getPiggyBankId() {
            return piggyBankId;
        }
    }

    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("Savings = " + pb.getSavings());
    }
}
