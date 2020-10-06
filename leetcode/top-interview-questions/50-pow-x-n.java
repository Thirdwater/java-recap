class Solution {
    public double myPow(double x, int n) {
        return pow(x, n);
    }
    public double nativePow(double x, int n) {
        return Math.pow(x, n);
    }
    public double pow(double x, int n) {
        // O(n) naive iteration: x^n = x * x^(n-1)
        // O(log n) iteration: x^n = (x^2)^(n / 2)
        if (n == 0) {
            return 1;
        }
        double odd = 1;
        if (n == Integer.MIN_VALUE) {
            odd = 1.0 / x;
            n++;
        }
        if (n < 0) {
            n = -n;
            x = 1.0 / x;
        }
        double base = x;
        while (n > 1) {
            if (n % 2 != 0) {
                n -= 1;
                odd *= x;
            } else {
                n /= 2;
                x *= x;
            }
        }
        return x * odd;
    }
}
