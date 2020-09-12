import java.util.Map;
import java.util.HashMap;

class Solution {

    private static Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int distinctClimbs = this.climbStairs(n - 1) + this.climbStairs(n - 2);
        cache.put(n, distinctClimbs);
        return distinctClimbs;
    }

}
