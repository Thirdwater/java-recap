class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            boolean sameChar = true;
            char nextPrefix = strs[0].charAt(i);
            for (String s: strs) {
                if (s.length() < i + 1 || s.charAt(i) != nextPrefix) {
                    sameChar = false;
                    break;
                }
            }
            if (sameChar) {
                commonPrefix.append(nextPrefix);
            } else {
                break;
            }
        }
        return commonPrefix.toString();
    }
}
