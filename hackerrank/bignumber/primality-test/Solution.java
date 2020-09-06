import java.util.Scanner;
import java.math.BigInteger;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            assert input.length() <= 100;
            BigInteger integer = new BigInteger(input);
            // Just need 1 to pass the test cases.
            boolean isProbablyPrime = integer.isProbablePrime(10);
            System.out.println(isProbablyPrime? "prime": "not prime");
        }
    }

}
