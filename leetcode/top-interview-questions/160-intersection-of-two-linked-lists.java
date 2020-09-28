/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // NOTE: "Intersection" is actually referring to the same object!
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        // # of nodes visited during the first pass:
        // A: a + i
        // B: b + i
        // # of nodes visited during second pass (swap heads):
        // A: a + i + b + i
        // B: b + i + a + i
        while (true) {
            if (nodeA == nodeB) {
                // Intersection found
                break;
            }
            if (nodeA == null && nodeB == null) {
                // No intersection
                break;
            }
            if (nodeA == null) {
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }
            if (nodeB == null) {
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
        }

        return nodeA;
    }
}
