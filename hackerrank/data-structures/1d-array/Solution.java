import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numInputs = scanner.nextInt();

            int[] array = new int[numInputs];
            for (int i = 0; i < numInputs; i++) {
                array[i] = scanner.nextInt();
            }

            for (int i : array) {
                System.out.println(i);
            }
        }
    }

}
