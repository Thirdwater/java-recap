class Solution {
    public int myAtoi(String str) {
        // Personally dislike designating one of the valid output as the
        // "magic" return value (0 in this case).
        // We are doing this here just to conform with the specs.
        int num = 0;

        // Note: does not look for best fit integer, but integer in
        // first non-space sequence!
        boolean started = false;
        boolean isNegative = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (started) {
                    break;
                } else {
                    continue;
                }
            }
            if (c == '+' || c == '-') {
                if (started) {
                    break;
                } else {
                    started = true;
                    if (c == '-') {
                        isNegative = true;
                    }
                    continue;
                }
            }

            // 48 - '0', 57 - '9'
            if (48 <= c && c <= 57) {
                started = true;
                long tmp = (long) num * 10;
                int newDigit = c - 48;
                if (isNegative) {
                    tmp -= newDigit;
                } else {
                    tmp += newDigit;
                }
                if (tmp >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (tmp <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                num = (int) tmp;
                continue;
            }

            break;
        }

        return num;
    }
}
