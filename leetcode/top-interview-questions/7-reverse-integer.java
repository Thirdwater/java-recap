class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == 0) {
            return 0;
        }
        boolean isNegative = x < 0;
        StringBuilder builder = new StringBuilder();
        builder.append(Math.abs(x));
        builder.reverse();
        if (isNegative) {
            builder.insert(0, "-");
        }
        long overflowSafe = Long.valueOf(builder.toString());
        if (overflowSafe > Integer.MAX_VALUE || overflowSafe < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) overflowSafe;
        }
    }
}
