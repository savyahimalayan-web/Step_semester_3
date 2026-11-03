import java.util.Arrays;
public class LibraryBookShelf {
    public static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int key = books[i];
            int j = i - 1;
            // Move bigger books one position to the right
            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }
            // Insert the book in its correct position
            books[j + 1] = key;
            System.out.println("After placing " + key + ": " + Arrays.toString(books));
        }
    }
    public static void main(String[] args) {
        int[] books = {30, 40, 20};
        shelf(books);
    }
}
