import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    // See Effective Java (3rd Ed.), item 6.
    private static final Pattern ALPHABETIC = Pattern.compile("[a-zA-Z]*");

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = scanner.nextLine();
            int startIndex = scanner.nextInt();
            int endIndex = scanner.nextInt();
            assert 1 <= s.length() && s.length() <= 100;
            // The maximum end index was mentioned but not defined by the prompt.
            // So we just set it to a sensible one.
            // Note that the substring method will still work as expected if
            // endIndex == s.length() && startIndex > 0
            assert 0 <= startIndex && startIndex < endIndex && endIndex <= s.length();
            assert ALPHABETIC.matcher(s).matches();

            System.out.println(s.substring(startIndex, endIndex));
        }
    }

}
