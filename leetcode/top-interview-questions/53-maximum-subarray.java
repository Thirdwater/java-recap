class Solution {

    public int maxSubArray(int[] nums) {
        return this.linearTimeMaxSubArray(nums);
    }

    public int divideAndConquerMaxSubArray(int[] nums) {
        // like the O(n) solution below;
        // but keep track of max at both ends?
        return Integer.MIN_VALUE;
    }

    public int linearTimeMaxSubArray(int[] nums) {
        // O(n)
        int endMax = nums[0];
        int totalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            endMax = Math.max(endMax + currentNum, currentNum);
            totalMax = Math.max(totalMax, endMax);
        }
        return totalMax;
    }

    public int polynomialTimeMaxSubArray(int[] nums) {
        // O(n^2) brute-force
        assert 1 <= nums.length && nums.length <= 20_000;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                max = Math.max(max, currentSum);
            }
        }
        return max;
    }

}
