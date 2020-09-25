class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int gapMax = nums[0];
        int touchMax = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int currentNum = nums[i];
            int gapMaxTmp = gapMax;
            gapMax = Math.max(gapMax, touchMax);
            touchMax = gapMaxTmp + currentNum;
        }
        return Math.max(gapMax, touchMax);
    }
}
