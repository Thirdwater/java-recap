import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    private static final Pattern REGEX = Pattern.compile("[A-Za-z !,?._'@]*");

    public static void main (String[] args) {
        /*
         * There are some cases that were not covered in the specification,
         * but otherwise still present in the test cases:
         *  - Empty input (pattern should've been * instead of +)
         *  - No input (to handle the same way as empty input)
         */
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNext()) {
                System.out.println("0");
                return;
            }
            // Trim to prevent empty token in the beginning in case of leading spaces.
            String input = scanner.nextLine().trim();
            assert REGEX.matcher(input).matches();
            assert 0 <= input.length() && input.length() <= 400_000;

            String delimiterRegex = "[ !,?._'@]+";
            String[] tokens = input.split(delimiterRegex);
            System.out.println(tokens.length);
            for (String token : tokens) {
                System.out.println(token);
            }
        }
    }

}
