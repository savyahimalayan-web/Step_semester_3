public class AttendanceTracker {
    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longestStreak = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                present++;
                streak++;
                if (streak > longestStreak) {
                    longestStreak = streak;
                }
            } else {
                streak = 0;
            }
        }
        return new int[]{present, longestStreak};
    }
    public static void main(String[] args) {
        int[] days = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0]);
        System.out.println("Longest streak: " + result[1]);
    }
}
