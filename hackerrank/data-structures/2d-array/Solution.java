import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[][] array = new int[6][6];
            for (int i = 0; i < 6; i++) {
                String[] rowItems = scanner.nextLine().split(" ");
                assert rowItems.length == 6;
                for (int j = 0; j < 6; j++) {
                    int item = Integer.parseInt(rowItems[j]);
                    assert -9 <= item && item <= 9;
                    array[i][j] = item;
                }
            }

            // There are 4x4 hourglasses
            int largestSum = Integer.MIN_VALUE;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int hourglassSum = (
                            array[i][j] + array[i][j + 1] + array[i][j + 2] +
                            array[i + 1][j + 1] +
                            array[i + 2][j] + array[i + 2][j + 1] + array[i + 2][j + 2]);
                    if (hourglassSum > largestSum) {
                        largestSum = hourglassSum;
                    }
                }
            }
            System.out.println(largestSum);
        }
    }

}
