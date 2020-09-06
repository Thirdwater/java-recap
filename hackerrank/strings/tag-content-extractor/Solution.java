import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Solution {

    // Group 1 denotes the name captured in the start tag and
    // used to match the end tag.
    // Group 2 denotes the content between the two tags.
    private static Pattern VALID_TAG = Pattern.compile("<(.+)>([^<]+)</\\1>");

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numLines = scanner.nextInt();
            scanner.nextLine();
            assert 1 <= numLines && numLines <= 100;
            int totalLength = 0;

            for (int i = 0; i < numLines; i++) {
                String line = scanner.nextLine();
                assert line.length() <= 10_000;
                totalLength += line.length();

                Matcher matcher = VALID_TAG.matcher(line);
                boolean isFound = false;
                while(matcher.find()) {
                    isFound = true;
                    System.out.println(matcher.group(2));
                }
                if (!isFound) {
                    System.out.println("None");
                }
            }

            assert totalLength <= 1_000_000;
        }
    }

}
