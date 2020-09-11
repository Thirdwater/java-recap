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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode left = l1;
        ListNode right = l2;
        ListNode sortedHead;
        boolean hasLeft = left != null;
        boolean hasRight = right != null;
        if (left.val < right.val) {
            sortedHead = left;
            left = left.next;
            hasLeft = left != null;
        } else {
            sortedHead = right;
            right = right.next;
            hasRight = right != null;
        }
        ListNode current = sortedHead;
        while (hasLeft || hasRight) {
            if (hasLeft && hasRight) {
                if (left.val < right.val) {
                    current.next = left;
                    hasLeft = left.next != null;
                    if (hasLeft) {
                        left = left.next;
                    }
                } else {
                    current.next = right;
                    hasRight = right.next != null;
                    if (hasRight) {
                        right = right.next;
                    }
                }
            } else if (hasLeft) {
                current.next = left;
                hasLeft = false;
            } else {
                current.next = right;
                hasRight = false;
            }
            current = current.next;
        }
        return sortedHead;
    }
}
