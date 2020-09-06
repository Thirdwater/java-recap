import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    private static final Pattern LOWERCASE_ALPHABETIC = Pattern.compile("[a-z]*");

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            assert LOWERCASE_ALPHABETIC.matcher(input).matches();
            assert input.length() <= 50;

            String inputReverse = new StringBuilder(input).reverse().toString();
            boolean isPalindrome = input.equals(inputReverse);
            System.out.println(isPalindrome? "Yes": "No");
        }
    }

}
