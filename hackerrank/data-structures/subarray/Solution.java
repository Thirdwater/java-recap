import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int arraySize = scanner.nextInt();
            assert 1 <= arraySize && arraySize <= 100;
            int[] array = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                array[i] = scanner.nextInt();
                assert -10_000 <= array[i] && array[i] <= 10_000;
            }

            int negativeCount = 0;
            for (int startIndex = 0; startIndex < arraySize; startIndex++) {
                for (int endIndex = startIndex; endIndex < arraySize; endIndex++) {
                    int[] subarray = Arrays.copyOfRange(array, startIndex, endIndex + 1);
                    int subarraySum = 0;
                    for (int item : subarray) {
                        subarraySum += item;
                    }
                    if (subarraySum < 0) {
                        negativeCount++;
                    }
                }
            }

            System.out.println(negativeCount);
        }
    }

}
