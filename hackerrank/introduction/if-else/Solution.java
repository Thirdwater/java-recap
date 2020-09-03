import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        assert 1 <= n && n <= 100;
        if (!Solution.isEven(n)) {
            System.out.println("Weird");
        } else {
            // n is even
            if (2 <= n && n <= 5) {
                System.out.println("Not Weird");
            } else if (6 <= n && n <= 20) {
                System.out.println("Weird");
            } else {
                System.out.println("Not Weird");
            }
        }
    }

    private static boolean isEven (int n) {
        return (n % 2) == 0;
    }

}
