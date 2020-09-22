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
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public boolean isPalindrome(ListNode head) {
        int size = 0;
        Deque<Integer> checkTail = new ArrayDeque<>();
        ListNode checkHead = head;
        while (head != null) {
            size++;
            checkTail.addFirst(head.val);
            head = head.next;
        }
        for (int i = 0; i < size / 2; i++) {
            int leftToRight = checkHead.val;
            int rightToLeft = checkTail.removeFirst();
            if (leftToRight != rightToLeft) {
                return false;
            }
            checkHead = checkHead.next;
        }
        return true;
    }
}
