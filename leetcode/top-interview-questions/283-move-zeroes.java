class Solution {
    public void moveZeroes(int[] nums) {
        // tail goes through each index per iteration
        // and puts any non-zero element to the head
        // head moves forward once whenever it gets a non-zero element
        if (nums.length < 2) {
            return;
        }
        int head = -1;
        for (int tail = 0; tail < nums.length; tail++) {
            int num = nums[tail];
            if (head == -1 && num == 0) {
                head = tail;
            }
            if (head != -1 && num != 0) {
                nums[head] = num;
                nums[tail] = 0;
                head++;
            }
        }
    }
}
