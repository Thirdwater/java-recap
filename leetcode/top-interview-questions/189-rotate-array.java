class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        // Save the subarray that will be wrapped over
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[nums.length - k + i];
        }

        // Shift the main subarray
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        // Wrap over the saved subarray
        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
    }
}
