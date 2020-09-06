import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numElements = scanner.nextInt();
            assert 1 <= numElements && numElements <= 4_000;

            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < numElements; i++) {
                list.add(scanner.nextInt());
            }

            int numQueries = scanner.nextInt();
            assert 1 <= numQueries && numQueries <= 4_000;
            scanner.nextLine();

            for (int i = 0; i < numQueries; i++) {
                String operation = scanner.nextLine();
                int index = scanner.nextInt();
                try {
                    if (operation.equals("Insert")) {
                        int value = scanner.nextInt();
                        list.add(index, value);
                    } else if (operation.equals("Delete")) {
                        list.remove(index);
                    }
                } catch (Exception e) {
                    // Skips invalid operations
                }
                if (i < numQueries - 1) {
                    scanner.nextLine();
                }
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i < list.size() - 1) {
                    System.out.print(" ");
                }
            }
        }
    }

}
