class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int uniqueHead = 0;
        int lastUnique = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if (current != lastUnique) {
                uniqueHead++;
                nums[uniqueHead] = current;
                lastUnique = current;
            }
        }
        return uniqueHead + 1;
    }
}
