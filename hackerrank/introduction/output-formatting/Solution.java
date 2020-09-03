import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s = scanner.next();
            int d = scanner.nextInt();

            System.out.format("%-15s%03d%n", s, d);

            if (i < 2) {
                scanner.nextLine();
            } else {
                scanner.close();
            }
        }
        System.out.println("================================");
    }

}
