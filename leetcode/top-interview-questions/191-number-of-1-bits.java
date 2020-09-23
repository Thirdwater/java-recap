public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return algorithmicHammingWeight(n);
    }
    public int nativeHammingWeight(int n) {
        return Integer.bitCount(n);
    }
    public int algorithmicHammingWeight(int n) {
        int weight = 0;
        for (int i = 0; i < 32; i++) {
            weight += (n >> i) & 1;
        }
        return weight;
    }
}
