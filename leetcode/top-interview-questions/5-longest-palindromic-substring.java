class Solution {
    public String longestPalindrome(String s) {
        return this.bruteForceLongestPalindrome(s);
    }
    public String quadraticTimeLongestPalindrome(String s) {
        // Instead of keeping track of the substring and its reverse to compare them,
        // try to check the characters that went into them instead.
        return s;
    }
    public String bruteForceLongestPalindrome(String s) {
        assert s.length() <= 1_000;
        if (s.length() < 2) {
            return s;
        }
        StringBuilder left;
        StringBuilder right;
        int maxLength = 0;
        String longestPalindrome = "";
        for (int start = 0; start < s.length() - maxLength; start++) {
            left = new StringBuilder();
            right = new StringBuilder();
            for (int end = start; end < s.length(); end++) {
                char current = s.charAt(end);
                left.append(current);
                right.insert(0, current);
                if (left.toString().equals(right.toString())) {
                    int newLength = left.length();
                    if (newLength > maxLength) {
                        maxLength = newLength;
                        longestPalindrome = left.toString();
                    }
                }
            }
        }
        return longestPalindrome;
    }
}
