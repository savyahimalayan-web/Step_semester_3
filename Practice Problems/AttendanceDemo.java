public class AttendanceDemo {
    static class AttendanceSheet {
        // Private array
        private String[] students;
        // Current count
        private int count;
        // Constructor
        public AttendanceSheet(int maxSize) {
            students = new String[maxSize];
            count = 0;
        }
        // Mark student present
        public void markPresent(String name) {
            // Avoid duplicates
            if (isPresent(name)) {
                return;
            }
            if (count < students.length) {
                students[count] = name;
                count++;
            }
        }
        // Check presence
        public boolean isPresent(String name) {
            for (int i = 0; i < count; i++) {
                if (students[i].equals(name)) {
                    return true;
                }
            }
            return false;
        }
        // Return count
        public int getPresentCount() {
            return count;
        }
    }
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}
