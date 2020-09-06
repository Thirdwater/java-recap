import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int cases = scanner.nextInt();
            scanner.nextLine();
            for (int line = 0; line < cases; line++) {
                String regex = scanner.nextLine();
                try {
                    Pattern.compile(regex);
                    System.out.println("Valid");
                } catch (PatternSyntaxException e) {
                    System.out.println("Invalid");
                }
            }
        }
    }

}
