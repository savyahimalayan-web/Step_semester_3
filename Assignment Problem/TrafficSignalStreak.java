import java.util.Scanner;

public class TrafficSignalStreak {

    static void findLongestStreak(String signalLog) {
        char maxChar = signalLog.charAt(0);
        int maxCount = 1;
        int count = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxCount) {
                maxCount = count;
                maxChar = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxCount + " times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);

        sc.close();
    }
}
