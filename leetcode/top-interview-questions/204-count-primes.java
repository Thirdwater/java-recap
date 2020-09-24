import java.math.BigInteger;

class Solution {

    private static final int CERTAINTY = 3;

    public int countPrimes(int n) {
        return loopCountPrimes(n);
    }

    public int loopCountPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        if (n > 2) {
            count++;
            for (int j = 2; 2 * j < n; j++) {
                notPrime[2 * j] = true;
            }
        }
        for (int i = 3; i < n; i+= 2) {
            if (!notPrime[i]) {
                count++;
                // sieve
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

    public int javaCountPrimes(int n, int certainty) {
        // timeout
        int count = 0;
        if (n > 2) {
            count++;
        }
        for (int i = 3; i < n; i+= 2) {
            BigInteger num = BigInteger.valueOf(i);
            if (num.isProbablePrime(certainty)) {
                count++;
            }
        }
        return count;
    }

}
