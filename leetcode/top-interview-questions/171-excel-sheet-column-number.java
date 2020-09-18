class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int base = (int) Math.pow(26, s.length() - i - 1);
            int n = s.charAt(i) - 64;
            num += base * n;
        }
        return num;
    }
}
