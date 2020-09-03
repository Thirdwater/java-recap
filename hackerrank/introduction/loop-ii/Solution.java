import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        assert 0 <= queries && queries <= 500;

        if (queries == 0) {
            return;
        }
        scanner.nextLine();

        int element;
        for (int q = 0; q < queries; q++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            assert 0 <= a && a <= 50;
            assert 0 <= b && b <= 50;
            assert 1 <= n && n <= 15;

            element = a;
            for (int i = 0; i < n; i++) {
                element += b * Math.pow(2, i);
                System.out.print(element);
                if (i < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            if (q < queries - 1) {
                scanner.nextLine();
            }
        }
        scanner.close();
    }

}
