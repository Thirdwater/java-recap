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
    public ListNode reverseList(ListNode head) {
        return recursiveReverseList(head);
    }
    public ListNode iterativeReverseList(ListNode head) {
        ListNode tail = null;
        while (head != null) {
            ListNode remaining = head.next;
            head.next = tail;
            tail = head;
            head = remaining;
        }
        return tail;
    }
    public ListNode recursiveReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode body = recursiveReverseList(next);
        next.next = head;
        head.next = null;
        return body;
    }
}
