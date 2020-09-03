import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        assert 2 <= n && n <= 20;

        int product = n;
        for (int i = 1; i <= 10; i++) {
            System.out.format("%d x %d = %d%n", n, i, product);
            product += n;
        }
    }

}
