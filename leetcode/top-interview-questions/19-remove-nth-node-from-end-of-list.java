/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        assert head != null;
        assert n >= 1;
        
        // Degenerate case: 1-element list
        if (head.next == null) {
            assert n == 1;
            return null;
        }
        
        // Iteration: forward pass
        ListNode current = head;
        ListNode beforeNLast = null;
        ListNode nLast = head;
        int currentNLastGap = 1;
        while (current.next != null) {
            // Increment such that current is ahead by n
            current = current.next;
            if (currentNLastGap == n) {
                nLast = nLast.next;
                if (beforeNLast == null) {
                    beforeNLast = head;
                } else {
                    beforeNLast = beforeNLast.next;
                }
            } else {
                currentNLastGap += 1;
            }
        }
        
        // Base case: end of forward pass
        if (beforeNLast == null) {
            // nLast == head, cut the head by 1
            return head.next;
        }
        if (nLast.next == null) {
            // n == 1, cut the tail by 1
            beforeNLast.next = null;
        } else {
            // 1 < n < list size, skip nLast
            beforeNLast.next = nLast.next;
        }
        return head;
    }
    
}