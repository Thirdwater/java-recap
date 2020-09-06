import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numArrays = scanner.nextInt();
            assert 1 <= numArrays && numArrays <= 20_000;

            List<List<Integer>> input = new ArrayList<List<Integer>>();
            for (int i = 0; i < numArrays; i++) {
                int numElements = scanner.nextInt();
                assert 0 <= numElements && numElements <= 50_000;

                List<Integer> array = new ArrayList<Integer>();
                for (int j = 0; j < numElements; j++) {
                    array.add(scanner.nextInt());
                }
                input.add(array);
            }

            int numQueries = scanner.nextInt();
            assert 1 <= numQueries && numQueries <= 1_000;

            for (int q = 0; q < numQueries; q++) {
                int line = scanner.nextInt() - 1;
                int position = scanner.nextInt() - 1;
                assert 1 <= line && line <= numArrays;

                try {
                    int value = input.get(line).get(position);
                    System.out.println(value);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("ERROR!");
                }
            }
        }
    }

}
