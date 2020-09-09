import java.util.Map;
import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
        // Stores (target-complement, index) key-value pairs.
        Map<Integer, Integer> complementMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = target - current;
            if (complementMap.containsKey(complement)) {
                int complementIndex = complementMap.get(complement);
                return new int[]{complementIndex, i};
            }
            complementMap.put(current, i);
        }
        throw new IllegalArgumentException();
    }

    public int[] bruteForceTwoSum(int[] nums, int target) {
        assert 2 <= nums.length && nums.length <= 100_000;
        for (int n: nums) {
            assert -1_000_000_000 <= n && n <= 1_000_000_000;
        }
        assert -1_000_000_000 <= target && target <= 1_000_000_000;

        // Since elements can be negative, we cannot skip those that are greater than the target.
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // Assumes there is exactly 1 valid answer (in either order).
        return null;
    }

}
