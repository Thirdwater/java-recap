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

    /**
     * Adds 2 non-negative integers represented by linked lists.
     *
     * Each number in the input and output is represented in a linked list
     * where each digit is stored in each node in reverse order.
     *
     * @param l1 Non-empty linked list representing a non-negative integer.
     * @param l2 Non-empty linked list representing a non-negative integer.
     * @return Linked list representing the sum of l1 and l2.
     */
    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode sumHead = new ListNode(0);
        ListNode sumTail = sumHead;
        int carry = 0;
        boolean hasNode1 = true;
        boolean hasNode2 = true;
        boolean done = false;
        do {
            int digit = carry;
            if (hasNode1) {
                digit += node1.val;
            }
            if (hasNode2) {
                digit += node2.val;
            }

            if (digit >= 10) {
                carry = (int) (digit / 10);
                digit = digit % 10;
            } else {
                carry = 0;
            }

            sumTail.val = digit;

            if (node1.next != null) {
                node1 = node1.next;
            } else {
                hasNode1 = false;
            }
            if (node2.next != null) {
                node2 = node2.next;
            } else {
                hasNode2 = false;
            }

            done = !(hasNode1 || hasNode2 || carry > 0);
            if (!done) {
                ListNode sumNext = new ListNode(0);
                sumTail.next = sumNext;
                sumTail = sumNext;
            }
        } while (!done);

        return sumHead;
    }

}
