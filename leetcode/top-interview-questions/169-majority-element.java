import java.util.Map;
import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        int maxNum = nums[0];
        int maxCount = 1;
        int threshold = nums.length / 2;
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int num: nums) {
            if (!numFrequencyMap.containsKey(num)) {
                numFrequencyMap.put(num, 0);
            }
            int newCount = numFrequencyMap.get(num) + 1;
            numFrequencyMap.put(num, newCount);
            if (newCount > maxCount) {
                maxNum = num;
                maxCount = newCount;
            }
            if (maxCount > threshold) {
                break;
            }
        }
        return maxNum;
    }
}
