import java.util.Scanner;
import java.math.BigInteger;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // We read as string first instead of nextBigInteger in order
            // to check the number of digits.
            String input1 = scanner.nextLine();
            String input2 = scanner.nextLine();
            assert input1.length() <= 200;
            assert input2.length() <= 200;
            BigInteger integer1 = new BigInteger(input1);
            BigInteger integer2 = new BigInteger(input2);
            assert integer1.compareTo(BigInteger.ZERO) >= 0;
            assert integer2.compareTo(BigInteger.ZERO) >= 0;

            System.out.println(integer1.add(integer2));
            System.out.println(integer1.multiply(integer2));
        }
    }

}
