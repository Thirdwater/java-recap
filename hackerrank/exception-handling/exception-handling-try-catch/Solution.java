import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input1 = scanner.nextLine();
            String input2 = scanner.nextLine();

            try {
                int x = Integer.parseInt(input1);
                int y = Integer.parseInt(input2);

                if (y == 0) {
                    System.out.println("java.lang.ArithmeticException: / by zero");
                } else {
                    System.out.println((int) x / y);
                }
            } catch (NumberFormatException e) {
                System.out.println("java.util.InputMismatchException");
            }
        }
    }

}
