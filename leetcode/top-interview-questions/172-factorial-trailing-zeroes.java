class Solution {

    public int trailingZeroes(int n) {
        return logNTrailingZeroes(n);
    }

    public int logNTrailingZeroes(int n) {
        // See wiki entry on trailing zero (de Polignac's formula)
        int count = 0;
        int factor = 5;
        while (factor <= n) {
            count += n / factor;
            factor *= 5;
        }
        return count;
    }

    public int bruteForceTrailingZeroes(int n) {
        if (n <= 4) {
            return 0;
        }
        // We only keep track of the last significant digit
        // Starting from 4! = 24
        int lastSigDigitFactorial = 4;
        int count = 0;
        for (int i = 5; i <= n; i++) {
            lastSigDigitFactorial *= i;
            while (lastSigDigitFactorial % 10 == 0) {
                count++;
                lastSigDigitFactorial /= 10;
            }
            lastSigDigitFactorial %= 10000;
        }
        return count;
    }

}
