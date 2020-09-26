public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            int ithBit = (n >>> i) & 1;
            if (ithBit == 1) {
                int reversethBit = (1 << (31 - i));
                reversed = reversethBit | reversed;
            }
        }
        return reversed;
    }
}
