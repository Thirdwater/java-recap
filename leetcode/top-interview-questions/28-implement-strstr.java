class Solution {
    public int strStr(String haystack, String needle) {
        // Don't use built-in functions for exercise
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean match = false;
            for (int j = 0; j < needle.length(); j++) {
                char current = haystack.charAt(i + j);
                char other = needle.charAt(j);
                if (current != other) {
                    break;
                }
                match = j == needle.length() - 1;
            }
            if (match) {
                return i;
            }
        }
        return -1;
    }
    public int builtInStrStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
