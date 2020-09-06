import java.util.Scanner;
import java.math.BigDecimal;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numInputs = scanner.nextInt();
            assert 1 <= numInputs && numInputs <= 200;
            String[] inputs = new String[numInputs];
            for (int i = 0; i < numInputs; i++) {
                inputs[i] = scanner.next();
                // 300 digits + minus sign + decimal point
                // i.e. slightly more permissive check
                assert inputs[i].length() <= 302;
            }

            Arrays.sort(inputs, new Comparator<String>() {
                @Override
                public int compare (String string1, String string2) {
                    // Need to handle the 2 extra null values if using array of
                    // size numInputs + 2.
                    BigDecimal decimal1 = new BigDecimal(string1);
                    BigDecimal decimal2 = new BigDecimal(string2);
                    return decimal2.compareTo(decimal1);
                }
            });

            for (int i = 0; i < numInputs; i++) {
                System.out.println(inputs[i]);
            }
        }
    }

}
