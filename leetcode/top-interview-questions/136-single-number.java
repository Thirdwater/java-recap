import java.util.Set;
import java.util.HashSet;

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int n: nums) {
            if (!unique.contains(n)) {
                unique.add(n);
            } else {
                unique.remove(n);
            }
        }
        return unique.toArray(new Integer[1])[0];
    }
}
