class Solution {

    public boolean isPowerOfThree(int n) {
        return loopIsPowerOfThree(n);
    }

    public boolean loopIsPowerOfThree(int n) {
        int power = 0;
        // 3^20 > 2^31 - 1
        int max = 20;
        while (power < max) {
            if (Math.pow(3, power) == n) {
                return true;
            }
            power++;
        }
        return false;
    }

}
