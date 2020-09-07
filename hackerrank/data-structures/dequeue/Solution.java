import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int arraySize = scanner.nextInt();
            int subarraySize = scanner.nextInt();
            assert 1 <= arraySize && arraySize <= 100_000;
            assert 1 <= subarraySize && subarraySize <= 100_000;
            assert subarraySize <= arraySize;

            Deque<Integer> deque = new ArrayDeque<Integer>();
            Set<Integer> uniqueSet = new HashSet<Integer>();
            int maxUnique = 0;
            for (int i = 0; i < arraySize; i++) {
                int element = scanner.nextInt();
                assert 0 <= element && element <= 10_000_000;

                if (i >= subarraySize) {
                    int oldestNumber = deque.removeFirst();
                    // Don't remove the number from the set if the same number
                    // is still present elsewhere in the deque subarray.
                    if (!deque.contains(oldestNumber)) {
                        uniqueSet.remove(oldestNumber);
                    }
                }

                deque.addLast(element);
                uniqueSet.add(element);

                maxUnique = Math.max(maxUnique, uniqueSet.size());
                if (maxUnique == subarraySize) {
                    break;
                }
            }
            System.out.println(maxUnique);
        }
    }

}
