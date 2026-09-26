public class LockerDemo {
    static class Locker {
        // Private code
        private String code;
        // Final locker number
        private final int lockerNumber;
        // Constructor
        public Locker(int lockerNumber, String code) {
            this.lockerNumber = lockerNumber;
            this.code = code;
        }
        // Change code
        public boolean changeCode(String currentCode, String newCode) {
            // Verify old code
            if (code.equals(currentCode)) {
                code = newCode;
                return true;
            }
            return false;
        }
        // Getter only for locker number
        public int getLockerNumber() {
            return lockerNumber;
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println(l.changeCode("1234", "5678"));
        System.out.println(l.changeCode("0000", "9999"));
    }
}
