/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        assert node.next != null;
        // Since we can't access the parent node, we just shift everything along
        ListNode head = node;
        ListNode last = head;
        while (head.next != null) {
            head.val = head.next.val;
            last = head;
            head = head.next;
        }
        last.next = null;
    }
}
