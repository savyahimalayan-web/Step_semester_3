import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        String reverse = new StringBuilder(word).reverse().toString();

        System.out.println("Reversed word: " + reverse);

        if (word.equals(reverse)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }

        sc.close();
    }
}
