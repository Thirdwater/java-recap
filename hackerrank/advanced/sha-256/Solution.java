import java.util.Scanner;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

    private static final Pattern ALPHANUMERIC = Pattern.compile("[a-zA-Z0-9]+");

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            assert 6 <= input.length() && input.length() <= 20;
            assert ALPHANUMERIC.matcher(input).matches();

            try {
                MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
                byte[] inputBytes = input.getBytes();
                byte[] digest = sha256.digest(inputBytes);
                for (byte digit: digest) {
                    System.out.format("%02x", digit);
                }
                System.out.println();
            } catch (NoSuchAlgorithmException e) {
                // Shouldn't happen
                // And "SHA-256" would be better as an enum
            }
        }
    }

}
