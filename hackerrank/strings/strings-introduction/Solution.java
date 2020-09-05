import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();

            int totalLength = a.length() + b.length();
            boolean isLexicographicalOrder = a.compareTo(b) <= 0;
            String capitalizedA = a.substring(0, 1).toUpperCase() + a.substring(1);
            String capitalizedB = b.substring(0, 1).toUpperCase() + b.substring(1);

            System.out.println(totalLength);
            System.out.println(isLexicographicalOrder? "No": "Yes");
            System.out.format("%s %s%n", capitalizedA, capitalizedB);
        }
    }

}
