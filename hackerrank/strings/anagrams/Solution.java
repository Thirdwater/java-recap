import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;
// The interface to fill in the solution doesn't allow any imports.
// We can still fully qualify the names instead or use alternatives:
//  - Forego some constraint checks
//  - Use arrays instead of <char, int> map

public class Solution {

    private static final Pattern ALPHABETIC = Pattern.compile("[a-zA-Z]*");

    static boolean isAnagram (String a, String b) {
        assert ALPHABETIC.matcher(a).matches();
        assert ALPHABETIC.matcher(b).matches();
        assert 0 <= a.length() && a.length() <= 50;
        assert 0 <= b.length() && b.length() <= 50;

        String lowercaseA = a.toLowerCase();
        String lowercaseB = b.toLowerCase();

        Map<Character, Integer> frequencyA = new HashMap<Character, Integer>();
        Map<Character, Integer> frequencyB = new HashMap<Character, Integer>();
        for (int i = 0; i < a.length(); i++) {
            char currentChar = lowercaseA.charAt(i);
            int count = 1;
            if (frequencyA.containsKey(currentChar)) {
                count = frequencyA.get(currentChar) + 1;
            }
            frequencyA.put(currentChar, count);
        }
        for (int i = 0; i < b.length(); i++) {
            char currentChar = lowercaseB.charAt(i);
            int count = 1;
            if (!frequencyA.containsKey(currentChar)) {
                return false;
            }
            if (frequencyB.containsKey(currentChar)) {
                count = frequencyB.get(currentChar) + 1;
            }
            frequencyB.put(currentChar, count);
            if (count > frequencyA.get(currentChar)) {
                return false;
            }
        }
        return frequencyA.equals(frequencyB);
    }

}
