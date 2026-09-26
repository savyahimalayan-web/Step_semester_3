public class ScorecardDemo {

    static class Scorecard {
        // Private array
        private boolean[] answers;
        // Tracks next position
        private int currentIndex;
        // Fixed question count
        private final int totalQuestions;

        // Constructor
        public Scorecard(int totalQuestions) {
            this.totalQuestions = totalQuestions;
            answers = new boolean[totalQuestions];
            currentIndex = 0;
        }

        // Record answer
        public void recordAnswer(boolean result) {

            if (currentIndex < totalQuestions) {
                answers[currentIndex] = result;
                currentIndex++;
            }
            else {
                System.out.println("No more answers allowed");
            }
        }

        // Calculate score
        public int getScore() {

            int count = 0;

            for (int i = 0; i < currentIndex; i++) {

                if (answers[i]) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score = " + sc.getScore());
    }
}
