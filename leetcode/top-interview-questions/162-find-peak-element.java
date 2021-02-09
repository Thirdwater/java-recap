class Solution {
    
    public int findPeakElement(int[] nums) {
        /* We first note that there is at least 1 peak:
         * Suppose there's no peak at one end;
         *     Then its neighbour must be greater
         *         (e.g. [1, 2, ..])
         *     If at any point, the subsequent neighbour is lesser, then we have a peak
         *         (e.g. [1, 2, .., 10, 11, 10, ..])
         *     Otherwise, we have a peak at the other end
         *         (e.g. [1, 2, .., 10, 11])
         */
        /* Note that the constraint nums[i] != nums[i + 1] for all i is needed
         * E.g.
         *     [1, 1] no peaks (all constant arrays)
         *     [1, 1, 0], [0, 1, 1] no peaks (monotomic with flat highs)
         */
        assert 1 <= nums.length && nums.length <= 1000;
        
        /* Binary search towards the side with strictly greater pivot neighbour is sufficient
         * since we will either find a peak (pivot) eventually or reach one of the ends (peak).
         */
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int mid = (start + end) / 2;
            boolean greaterThanLeft = (mid == 0) || (nums[mid - 1] < nums[mid]);
            boolean greaterThanRight = (mid == nums.length - 1) || (nums[mid] > nums[mid + 1]);
            if (greaterThanLeft && greaterThanRight) {
                return mid;
            } else if (greaterThanLeft) {
                start = mid + 1;
            } else {
                // greaterThanRight (due to no consecutive numbers constraint)
                end = mid - 1;
            }
        }
        // Handles edge cases where the array is small or the peak is at the beginning (mid index 0.5 rounds down).
        return start;
    }
    
}