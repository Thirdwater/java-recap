/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode step = head;
        ListNode skip = head;
        while (skip != null && skip.next != null) {
            step = step.next;
            skip = skip.next.next;
            if (step == skip) {
                return true;
            }
        }
        return false;
    }
}
