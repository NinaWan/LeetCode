/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next) {
            return head;
        }

        int length = 0;
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null) {
            slow = slow.next;
            length++;
        }

        slow = head;

        if (k % length == 0) {
            return head;
        }

        for (int i = 0; i < k % length; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}