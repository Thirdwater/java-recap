public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        // Just adding sensible checks for practice.
        assert k <= s.length();
        // 0 technically works with the given output format,
        // but we will just get empty strings on 2 lines.
        assert k >= 0;
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        int numberOfkSubstrings = s.length() - k + 1;

        for (int i = 1; i < numberOfkSubstrings; i++) {
            String current = s.substring(i, i + k);
            if (current.compareTo(smallest) < 0) {
                smallest = current;
            }
            if (current.compareTo(largest) > 0) {
                largest = current;
            }
        }
        return smallest + "\n" + largest;
    }

}
