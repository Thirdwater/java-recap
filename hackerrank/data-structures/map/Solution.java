import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numEntries = scanner.nextInt();
            assert 1 <= numEntries && numEntries <= 100_000;
            scanner.nextLine();

            Map<String,Integer> phoneBook = new HashMap<String, Integer>();
            for (int i = 0; i < numEntries; i++) {
                String name = scanner.nextLine();
                String numberString = scanner.nextLine();
                assert numberString.length() == 8;
                assert numberString.charAt(0) != '0';
                int number = Integer.parseInt(numberString);

                // Use most recent number in case of duplicate entries.
                phoneBook.put(name, number);
            }

            int numQueries = 0;
            while (scanner.hasNext()) {
                String queryName = scanner.nextLine();
                numQueries++;
                if (phoneBook.containsKey(queryName)) {
                    int number = phoneBook.get(queryName);
                    System.out.format("%s=%d%n", queryName, number);
                } else {
                    System.out.println("Not found");
                }
            }
            assert 1 <= numQueries && numQueries <= 100_000;
        }
    }

}
