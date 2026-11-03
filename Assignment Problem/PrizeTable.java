import java.util.Arrays;
public class PrizeTable {
    public static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int maxIndex = i;
            // Find the largest mark
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Swap only if required
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }
        return swaps;
    }
    public static void main(String[] args) {
        int[] marks = {45, 90, 60, 75};
        int swaps = prizeTable(marks);
        System.out.println("Sorted Marks: " + Arrays.toString(marks));
        System.out.println("Total Swaps: " + swaps);
    }
}
