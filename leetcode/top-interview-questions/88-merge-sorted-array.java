import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Deque<Integer> tmpStorage = new LinkedList<>();
        int head2 = 0;
        for (int head1 = 0; head1 < m + n; head1++) {
            int current1 = nums1[head1];
            if (head1 >= m) {
                current1 = Integer.MAX_VALUE;
            }
            int current2 = Integer.MAX_VALUE;
            if (head2 < n) {
                current2 = nums2[head2];
            }
            int currentTmp = Integer.MAX_VALUE;
            boolean hasTmp = tmpStorage.size() > 0;
            if (hasTmp) {
                currentTmp = tmpStorage.peekFirst();
            }

            int min = Math.min(Math.min(current1, current2), currentTmp);
            if (current1 == min) {
                continue;
            } else {
                if (head1 < m) {
                    tmpStorage.addLast(nums1[head1]);
                }
                if (currentTmp == min) {
                    nums1[head1] = currentTmp;
                    tmpStorage.removeFirst();
                } else if (current2 == min) {
                    nums1[head1] = current2;
                    head2++;
                }
            }
        }
    }
}
