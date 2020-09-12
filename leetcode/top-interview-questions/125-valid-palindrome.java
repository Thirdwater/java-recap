class Solution {public boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        String cleanedString = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        StringBuilder builder = new StringBuilder(cleanedString);
        builder.reverse();
        return cleanedString.equals(builder.toString());
    }
}
