import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    private static final Pattern LOWERCASE = Pattern.compile("[a-z]+");

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numPairs = scanner.nextInt();
            assert 1 <= numPairs && numPairs <= 100_000;

            Set<String> pairs = new HashSet<String>();
            for (int i = 0; i < numPairs; i++) {
                String pair = scanner.nextLine();

                String[] items = pair.split(" ");
                String left = items[0];
                String right = items[1];
                assert left.length() <= 5;
                assert right.length() <= 5;
                assert LOWERCASE.matcher(left).matches();
                assert LOWERCASE.matcher(right).matches();

                // Items just need to be delimited by a [^a-z].
                pairs.add(pair);
                System.out.println(pairs.size());
            }
        }
    }

}
