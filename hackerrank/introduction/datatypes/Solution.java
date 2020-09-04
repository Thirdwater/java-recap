import java.util.Scanner;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int cases = scanner.nextInt();
            assert cases >= 0;
            if (cases == 0) {
                return;
            }
            scanner.nextLine();

            for (int i = 0; i < cases; i++) {
                String input = scanner.nextLine();
                try {
                    long l = Long.parseLong(input);
                    System.out.format("%d can be fitted in:", l);
                    System.out.println();

                    // Converting long down to int/short/byte will not preserve
                    // the number if it doesn't fit.
                    // Converting back up to long preserves the number, so
                    // checking this round-trip-converted number against the
                    // original is enough.
                    if ((long)(byte)l == l) {
                        System.out.println("* byte");
                    }
                    if ((long)(short)l == l) {
                        System.out.println("* short");
                    }
                    if ((long)(int)l == l) {
                        System.out.println("* int");
                    }
                    System.out.println("* long");

                } catch (NumberFormatException e) {
                    System.out.format("%s can't be fitted anywhere.%n", input);
                }
            }
        }
    }

}
