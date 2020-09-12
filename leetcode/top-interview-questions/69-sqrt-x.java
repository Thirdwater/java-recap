class Solution {

    public int mySqrt(int x) {
        return this.bisectionMySqrt(x);
    }

    public int bisectionMySqrt(int x) {
        if (x == 0) {
            return x;
        }
        if (x < 4) {
            return 1;
        }
        long low = 0;
        long high = Math.min(x, 46341);
        long mid = (long) ((low + high) / 2.0);
        long square = mid * mid;
        long nextSquare = (mid + 1) * (mid + 1);
        while (!(square <= x && x < nextSquare)) {
            if (x < square) {
                high = mid;
            }
            if (x >= nextSquare) {
                low = mid;
            }
            mid = (long) ((low + high) / 2.0);
            square = mid * mid;
            nextSquare = (mid + 1) * (mid + 1);
        }
        return (int) Math.floor(mid);
    }

    public int bruteForceMySqrt(int x) {
        long i = 0;
        while (i * i <= x) {
            i++;
        }
        return (int) i - 1;
    }

}
